package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.pyc.PyObject
import com.freddieposer.scaly.typechecker.context.TypeContext.Location
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType
import com.freddieposer.scaly.typechecker.types.stdtypes.ScalyValType.ScalyNothingType
import com.freddieposer.scaly.typechecker.types.{ScalyASTClassType, ScalyFunctionType, ScalyTupleType, ScalyType}

abstract class IST extends {

  val typ: ScalyType

}

class IST_CompilationUnit(val classes: List[IST_Class]) extends IST {

  val typ: ScalyType = ScalyNothingType

}

//TODO: Parents
case class IST_Class(
                      name: String,
                      members: Map[String, IST_Member],
                      typ: ScalyASTClassType
                    ) extends IST {


}

sealed abstract class IST_Statement extends IST

sealed abstract class IST_Member extends IST_Statement {
  val id: String
}

case class IST_Def(
                    id: String,
                    params: List[Map[String, ScalyType]],
                    expr: IST_Expression,
                    typ: ScalyType
                  ) extends IST_Member {

  def func: IST_Function = IST_Function.build(params, expr, typ)

}

case class IST_Val(id: String, expr: IST_Expression, typ: ScalyType) extends IST_Member

case class IST_Var(id: String, expr: IST_Expression, typ: ScalyType) extends IST_Member


sealed abstract class IST_Expression extends IST_Statement

case class IST_Function(
                         args: List[String],
                         body: IST_Expression,
                         typ: ScalyFunctionType
                       ) extends IST_Expression

object IST_Function {

  def build(params: List[Map[String, ScalyType]], expr: IST_Expression, returnType: ScalyType): IST_Function =
    params match {
      case Nil => IST_Function(Nil, expr, ScalyFunctionType(None, returnType))
      case ps :: Nil =>
        IST_Function(ps.keys.toList, expr, ScalyFunctionType(Some(ScalyTupleType(ps.values.toList)), returnType))
      case ps :: pss =>
        IST_Function(
          ps.keys.toList,
          build(pss, expr, returnType),
          //FIXME
          ScalyFunctionType.build(returnType, params.map(_.values.toList)).asInstanceOf[ScalyFunctionType]
        )
    }

}


case class IST_If(
                   cond: IST_Expression,
                   tBranch: IST_Expression,
                   fBranch: Option[IST_Expression],
                   typ: ScalyType
                 ) extends IST_Expression

case class IST_Literal(py: PyObject, typ: ScalyValType) extends IST_Expression

case class IST_Block(statements: List[IST_Statement], typ: ScalyType) extends IST_Expression

//TODO: defs without application - perhaps could use the @property
case class IST_Application(lhs: IST_Expression, args: List[IST_Expression], typ: ScalyType) extends IST_Expression

//TODO: Constructor arguments
case class IST_New(name: String, args: List[IST_Expression], typ: ScalyType) extends IST_Expression

//TODO: This transformation should be used in future for the various types
//  e.g. when the arm selected is a def
case class IST_Select(lhs: IST_Expression, rhs: String, typ: ScalyType) extends IST_Expression

case class IST_Name(name: String, location: Location) extends IST_Expression {

  override val typ: ScalyType = location.typ

}

case class IST_TupleExpr(elems: List[IST_Expression], typ: ScalyTupleType) extends IST_Expression