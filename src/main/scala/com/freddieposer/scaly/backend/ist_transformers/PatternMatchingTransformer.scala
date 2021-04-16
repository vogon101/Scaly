package com.freddieposer.scaly.backend.ist_transformers

import com.freddieposer.scaly.backend.internal.Bytecode._
import com.freddieposer.scaly.backend.internal.BytecodeSnippets.ThrowException
import com.freddieposer.scaly.backend.internal.CodeGenerationUtils._
import com.freddieposer.scaly.backend.internal._
import com.freddieposer.scaly.backend.ist_transformers.PatternMatchingTransformer.IST_CompiledPattern
import com.freddieposer.scaly.backend.pyc.PyTrue
import com.freddieposer.scaly.backend.pyc.defs.PyOpcodes
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyIntType, ScalyNothingType}
import com.freddieposer.scaly.typechecker.types.{ScalyFunctionType, SymbolSource}

/**
 * Transformer compiles pattern match expressions to IST_If
 */
class PatternMatchingTransformer extends ISTExprTransformer {

  private val _MATCH_NAME: String = "__match__tmp__impl__"
  private var _MATCH_COUNT: Int = 0

  override def transformExpr(ist: IST_Expression): IST_Expression = ist match {
    case expr: IST_Match =>
      compileMatch(expr)
    case _ => descend(ist)
  }

  private def transformPattern(pattern: IST_Pattern): (Option[IST_Expression], IST_Pattern) = pattern match {
    case IST_ExtractorPattern(function, pats, _) =>
      (Some(function), IST_TuplePattern(pats))
    case p => (None, p)
  }

  def compileMatch(matchExpr: IST_Match): IST_Expression = withMatch {

    val IST_Match(lhs, cases, _) = matchExpr

    val assign =
      IST_Assignment(match_name, Location(lhs.typ, SymbolSource.LOCAL_WRITABLE), (~DUP_TOP).r) + (~POP_TOP)

    val patternsBC = cases.map(c => compilePattern(c.pattern))

    def descend(ps: List[(IST_Case, IST_CompiledPattern)]): IST_Expression = ps match {
      case Nil => ThrowException("Match error".toPy)
      case (c, IST_CompiledPattern(binds, cond)) :: rest =>
        (~DUP_TOP).r +
          IST_If(
            cond,
            (~DUP_TOP).r +
              IST_Function(c.pattern.bindings.keys.toList, transformExpr(c.rhs), ScalyFunctionType(None, ScalyNothingType), c.closedVars, c.freeVars) +
              (~ROT_TWO).r +
              binds + (CALL_FUNCTION, c.pattern.bindings.size.toByte).r + ~ROT_TWO + ~POP_TOP,
            Some(descend(rest)),
            c.typ
          )
    }

    lhs + assign + descend(cases zip patternsBC)

  }

  def compilePatternCondition(pattern: IST_Pattern): IST_Expression = {
    pattern match {
      case IST_LiteralPattern(literal) =>
        literal + (COMPARE_OP, 2.toByte)
      case IST_VariablePattern(name, matchType) =>
        (~POP_TOP).r + IST_Literal(PyTrue, ScalyBooleanType)
      case IST_TuplePattern(pats) =>
        pats.map(compilePatternCondition)
          .zipWithIndex.map {
          case (cond, 0) =>
            (~DUP_TOP).r + IST_Literal(0.toPy, ScalyIntType) + (~BINARY_SUBSCR) + cond
          case (cond, i) =>
            (~ROT_TWO).r + (~DUP_TOP) + IST_Literal(i.toPy, ScalyIntType) + (~BINARY_SUBSCR) +
              cond +
              (~ROT_THREE) + (~ROT_THREE) + (~BINARY_AND)
        }.flat + ~ROT_TWO + ~POP_TOP

      case IST_ExtractorPattern(func, pats, _) =>
        func + ~ROT_TWO + (CALL_FUNCTION, 1.toByte) + compilePatternCondition(IST_TuplePattern(pats))

    }
  }

  def compilePatternBindings(pattern: IST_Pattern): IST_Expression = {
    pattern match {
      case IST_LiteralPattern(_) => (~POP_TOP).r
      case IST_VariablePattern(_, _) => (~NOP).r
      case IST_TuplePattern(pats) =>
        val outerName = match_name
        (~POP_TOP).r + pats.zipWithIndex.map {
          case (pattern, i) => withMatch {
            val innerBind = compilePatternBindings(pattern)
            IST_Name(outerName, Location.local) +
              IST_Assignment(match_name, Location.local_w, IST_Literal(i.toPy, ScalyIntType) + (~BINARY_SUBSCR)) +
              ~POP_TOP +
              IST_Name(match_name, Location.local) +
              innerBind
          }
        }.flat

      case IST_ExtractorPattern(func, pats, _) =>
        func + ~ROT_TWO + (CALL_FUNCTION, 1.toByte) +
          IST_Assignment(match_name, Location.local_w, (~DUP_TOP).r) + ~POP_TOP +
          compilePatternBindings(IST_TuplePattern(pats))

    }
  }

  def compilePattern(pattern: IST_Pattern): IST_CompiledPattern =
    IST_CompiledPattern(compilePatternBindings(pattern), compilePatternCondition(pattern))


  def match_name: String = (_MATCH_NAME + _MATCH_COUNT)

  def withMatch[T](f: => T): T = {
    _MATCH_COUNT += 1
    val res = f
    _MATCH_COUNT -= 1
    res
  }

}

object PatternMatchingTransformer {

  case class IST_CompiledPattern(binds: IST_Expression, cond: IST_Expression)

}
