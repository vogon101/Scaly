package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.AST.ClassParam
import com.freddieposer.scaly.backend.pyc.PyObject
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.{ScalyBooleanType, ScalyNothingType, ScalyUnitType}
import com.freddieposer.scaly.typechecker.types.{ScalyASTTemplateType, ScalyFunctionType, ScalyTupleType, ScalyType}

abstract class IST extends {

  val typ: ScalyType

}

class IST_CompilationUnit(val classes: List[IST_Template]) extends IST {

  val typ: ScalyType = ScalyNothingType

}

sealed abstract class IST_Template extends IST {

  val name: String
  val parent: Option[String]
  val parentParams: List[IST_Expression]
  val defs: Map[String, IST_Def]
  val statements: List[IST_Statement]
  val params: List[ClassParam]


}

//TODO: Parents
case class IST_Class(
                      name: String,
                      params: List[ClassParam],
                      parent: Option[String],
                      parentParams: List[IST_Expression],
                      defs: Map[String, IST_Def],
                      statements: List[IST_Statement],
                      //TODO: should this be ClassParam - it is an AST subtype
                      typ: ScalyASTTemplateType
                    ) extends IST_Template

case class IST_Object(
                       name: String,
                       parent: Option[String],
                       parentParams: List[IST_Expression],
                       defs: Map[String, IST_Def],
                       statements: List[IST_Statement],
                       typ: ScalyASTTemplateType
                     ) extends IST_Template {

  val params: List[ClassParam] = Nil

}

sealed abstract class IST_Statement extends IST {
  val maxStack: Int
}

sealed abstract class IST_Member extends IST_Statement {
  val id: String
  val expr: IST_Expression
}

object IST_Member {

  def unapply(arg: IST_Member): Option[(String, IST_Expression)] = Some((arg.id, arg.expr))

}

case class IST_Def(
                    id: String,
                    params: List[Map[String, ScalyType]],
                    expr: IST_Expression,
                    typ: ScalyType,
                    closedVars: Map[String, Location],
                    freeVars: Map[String, Location]
                  ) extends IST_Member {

  lazy val func: IST_Function = IST_Function.build(params, expr, typ, closedVars, freeVars)
  override lazy val maxStack: Int = func.maxStack
}

case class IST_Val(id: String, expr: IST_Expression, location: Location) extends IST_Member {
  override lazy val maxStack: Int = expr.maxStack + 2
  override val typ: ScalyType = location.typ
}

case class IST_Var(id: String, expr: IST_Expression, location: Location) extends IST_Member {
  override lazy val maxStack: Int = expr.maxStack + 2
  override val typ: ScalyType = location.typ
}


sealed abstract class IST_Expression extends IST_Statement {
  val maxStack: Int
}

sealed case class RawISTExpr(bcl: BytecodeList) extends IST_Expression with Iterable[Bytecode] {
  override val maxStack: Int = 0
  override val typ: ScalyType = ScalyUnitType

  override def iterator: Iterator[Bytecode] = bcl.iterator
}

case class IST_Function(
                         args: List[String],
                         body: IST_Expression,
                         typ: ScalyFunctionType,
                         closedVars: Map[String, Location],
                         freeVars: Map[String, Location]
                       ) extends IST_Expression {
  //Actually smaller but this is a decent estimate
  //Remember this is the stack size of this _as an expression_
  //  THe stacksize of the code object should be body.maxStack
  override lazy val maxStack: Int = freeVars.size + 2
}

object IST_Function {

  def build(params: List[Map[String, ScalyType]], expr: IST_Expression, returnType: ScalyType, closedVars: Map[String, Location],
            freeVars: Map[String, Location]): IST_Function =
    params match {
      case Nil => IST_Function(Nil, expr, ScalyFunctionType(None, returnType), closedVars, freeVars)
      case ps :: Nil =>
        IST_Function(ps.keys.toList, expr, ScalyFunctionType(Some(ScalyTupleType(ps.values.toList)), returnType), closedVars, freeVars)
      case ps :: pss =>
        IST_Function(
          ps.keys.toList,
          build(pss, expr, returnType, closedVars, freeVars),
          //FIXME
          ScalyFunctionType.build(returnType, params.map(_.values.toList)).asInstanceOf[ScalyFunctionType],
          closedVars,
          freeVars
        )
    }

}


case class IST_If(
                   cond: IST_Expression,
                   tBranch: IST_Expression,
                   fBranch: Option[IST_Expression],
                   typ: ScalyType
                 ) extends IST_Expression {
  override lazy val maxStack: Int = List(cond.maxStack, tBranch.maxStack, fBranch.map(_.maxStack).getOrElse(0)).max
}

case class IST_Literal(py: PyObject, typ: ScalyValType) extends IST_Expression {
  override lazy val maxStack: Int = 1
}

sealed class IST_Sequence(val statements: List[IST_Statement], val typ: ScalyType) extends IST_Expression with Iterable[IST_Statement] {
  override lazy val maxStack: Int = (1 :: statements.map(_.maxStack)).sum

  override def iterator: Iterator[IST_Statement] = statements.iterator
}

object IST_Sequence {

  def apply(statements: List[IST_Statement], typ: ScalyType): IST_Sequence = new IST_Sequence(statements, typ)

  def unapply(arg: IST_Sequence): Option[(List[IST_Statement], ScalyType)] = Some((arg.statements, arg.typ))

}

case class IST_Block(override val statements: List[IST_Statement], override val typ: ScalyType)
  extends IST_Sequence(statements, typ) {
  override lazy val maxStack: Int = (1 :: statements.map(_.maxStack)).max
}


//TODO: defs without application - perhaps could use the @property
case class IST_Application(lhs: IST_Expression, args: List[IST_Expression], typ: ScalyType) extends IST_Expression {
  override lazy val maxStack: Int = List(lhs.maxStack, args.map(_.maxStack).sum, 1).max
}

case class IST_New(name: String, args: List[IST_Expression], typ: ScalyType) extends IST_Expression {
  override lazy val maxStack: Int = List(1, args.map(_.maxStack).sum).max
}

//TODO: This transformation should be used in future for the various types
//  e.g. when the arm selected is a def
case class IST_Select(lhs: IST_Expression, rhs: String, typ: ScalyType) extends IST_Expression {
  override lazy val maxStack: Int = List(lhs.maxStack, 1).max
}

case class IST_Name(name: String, location: Location) extends IST_Expression {

  //Varies but this is an upper bound
  override lazy val maxStack: Int = 2
  override val typ: ScalyType = location.typ

}

//TODO: More complex assignments
case class IST_Assignment(name: String, location: Location, rhs: IST_Expression) extends IST_Expression {


  override lazy val maxStack: Int = Math.max(rhs.maxStack, 2)
  override val typ: ScalyType = ScalyUnitType

}

case class IST_TupleExpr(elems: List[IST_Expression], typ: ScalyTupleType) extends IST_Expression {
  override lazy val maxStack: Int = elems.map(_.maxStack).sum + 1
}

case class IST_While(cond: IST_Expression, body: IST_Expression) extends IST_Expression {
  override lazy val maxStack: Int = Math.max(cond.maxStack, body.maxStack)
  override val typ: ScalyType = ScalyUnitType
}

case class IST_IsNone(lhs: IST_Expression) extends IST_Expression {
  override lazy val maxStack: Int = lhs.maxStack + 1
  override val typ: ScalyType = ScalyBooleanType
}

case class IST_Match(lhs: IST_Expression, cases: List[IST_Case], typ: ScalyType) extends IST_Expression {
  override val maxStack: Int = 200
}

case class IST_Subscript(lhs: IST_Expression, rhs: Int, typ: ScalyType) extends IST_Expression {
  override val maxStack: Int = 1
}