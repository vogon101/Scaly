package com.freddieposer.scaly.parsing.parsetree

trait ParseTree extends HasToStringTree {

  override def toStringTree: StringTree = this.toString

}

class CompilationUnit(val topStatements: List[TopStatement]) extends ParseTree {

  override def toStringTree: StringTree =
    StringTree.fromIndexedList("CU", topStatements)

}

abstract class Def extends ParseTree

abstract class Dcl extends ParseTree

abstract class Expr extends ParseTree

abstract class Literal extends Expr

sealed trait TopStatement extends Def

class ScalyClassDef(
                     val id: String,
                     val parents: Option[String],
                     val body: Option[TemplateBody],
                     val params: List[ClassParamClause]
                   ) extends TopStatement {

  override def toStringTree: StringTree =
    StringTreeNode("Class Def", List(
      "id" -> id,
      "parents" -> parents,
      "body" -> body,
      "params" -> StringTree.fromIndexedList("", params)
    ))

}

class ScalyObjectDef(
                      val id: String,
                      val parents: Option[String],
                      val body: Option[TemplateBody]
                    ) extends Def with TopStatement {

  override def toStringTree: StringTree =
    StringTreeNode("Object Def", List(
      "id" -> id,
      "parents" -> parents,
      "body" -> body
    ))

}

class ClassParam(
                  val modifiers: List[String],
                  //TODO: Stop using so many strings - should be enums
                  val memberType: String,
                  val id: String,
                  val paramType: ScalyType, //TODO
                  val defaultValue: Option[Expr]
                ) extends ParseTree {

  override def toStringTree: StringTree =
    StringTreeNode("Class Param", List(
      "modifiers" -> modifiers.mkString(", "),
      "member type" -> memberType,
      "id" -> id,
      "param type" -> paramType.toStringTree,
      "default" -> defaultValue
    ))

}

class ClassParamClause(val classParams: List[ClassParam]) extends ParseTree {

  override def toStringTree: StringTree =
    StringTree.fromIndexedList("Class Params", classParams)

}

class Param(
           val id: String,
           val paramType: Option[ScalyType],
           val default: Option[Expr]
           ) extends ParseTree {

  override def toStringTree: StringTree =
    StringTreeNode("Param", List(
      "id" -> id,
      "type" -> paramType,
      "default" -> default
    ))

}

class ParamClause(val params: List[Param]) extends ParseTree {

  override def toStringTree: StringTree =
    StringTree.fromIndexedList("Params", params)

}

abstract class ScalyType extends ParseTree

case class ScalyTypeName(name: IDExpr) extends ScalyType{
  override def toStringTree: StringTree = f"Type: ${name.members.mkString(".")}"
}
case class ScalyTupleType(types: List[ScalyType]) extends ScalyType {
  override def toStringTree: StringTree =
    f"Tuple Type: ${types.map(_.toStringTree.toString).mkString(", ")}"
}
case class ScalyFunctionType(arguments: List[ScalyType], returnType: ScalyType) extends ScalyType {
  override def toStringTree: StringTree =
    f"Type: ${arguments.map(_.toStringTree.toString).mkString(", ")} => $returnType"
}

class TemplateBody(val statements: List[TemplateStatement]) extends ParseTree {

  override def toStringTree: StringTree =
    StringTree.fromIndexedList("Template Body", statements)

}

sealed trait TemplateStatement extends ParseTree

final case class TemplateDef(mDef: Def, modifiers: List[String]) extends TemplateStatement {
  override def toStringTree: StringTree = StringTreeNode(
    "Template Def", List(
      "def" -> mDef.toStringTree,
      "mods" -> modifiers.mkString(", ")
    )
  )
}

final case class TemplateDcl(mDcl: Dcl, modifiers: List[String]) extends TemplateStatement {
  override def toStringTree: StringTree = StringTreeNode(
    "Template Dcl", List(
      "dcl" -> mDcl.toStringTree,
      "mods" -> modifiers.mkString(", ")
    )
  )
}

final case class TemplateExpr(mExpr: Expr) extends TemplateStatement {
  override def toStringTree: StringTree = mExpr.toStringTree
}

final case class ValDcl(ids: List[String], dclType: ScalyType) extends Dcl {
  override def toStringTree: StringTree = StringTreeNode(
    "Val Dcl", List(
      "ids" -> ids.mkString(", "),
      "type" -> dclType.toStringTree
    )
  )
}

final case class VarDcl(ids: List[String], dclType: ScalyType) extends Dcl {
  override def toStringTree: StringTree = StringTreeNode(
    "Var Dcl", List(
      "ids" -> ids.mkString(", "),
      "type" -> dclType.toStringTree
    )
  )
}

final case class FunDcl(name: String, params: List[ParamClause], returnType: Option[ScalyType]) extends Dcl {
  override def toStringTree: StringTree = StringTreeNode(
    "Function Dcl", List(
      "name" -> name,
      "params" -> StringTree.fromIndexedList("", params),
      "returns" -> returnType
    )
  )
}

final case class FunDef(dcl: FunDcl, expr: Expr) extends Def {
  override def toStringTree: StringTree = StringTreeNode(
    "Function Def", List(
      "dcl" -> dcl.toStringTree,
      "expr" -> expr.toStringTree
    )
  )
}

class PatVarDef extends Def
class PatValDef extends Def