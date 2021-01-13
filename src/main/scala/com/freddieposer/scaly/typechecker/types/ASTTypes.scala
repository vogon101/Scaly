package com.freddieposer.scaly.typechecker.types

import com.freddieposer.scaly.AST._
import com.freddieposer.scaly.typechecker.context.TypeContext.{Location, TypeMap}
import com.freddieposer.scaly.typechecker.types.stdtypes.{ScalyObject, ScalyValType}

case class ScalyASTPlaceholderType(node: AST_ScalyType) extends ASTScalyType with PlaceholderType {
  override lazy val memberTypes: TypeMap = ???
  override lazy val parent: Option[ScalyType] = ???

  override def constructor: Option[List[ClassParam]] = ???

  override def globalName: Option[String] = node match {
    case AST_ScalyTypeName(name) => Some(name)
    case _ => None
  }
}

abstract class ScalyASTTemplateType extends ASTScalyType with PlaceholderType{

  val name: String
  protected val _parent: Option[ScalyType]
  val node: TemplateDef

  override val globalName: Option[String] = Some(name)
  override lazy val parent: Option[ScalyType] = _parent.orElse(Some(ScalyObject))
  lazy val parentConstructor: Option[List[Expr]] = node.parents.headOption.map(_._2)

  override lazy val memberTypes: TypeMap = construct({

    def convertClause(clause: List[FunParam]): ScalyType =
      clause match {
        case Nil => ScalyValType.ScalyUnitType
        case x :: Nil => ScalyASTPlaceholderType(x.pType)
        case _ => ScalyTupleType(clause.map(p => ScalyASTPlaceholderType(p.pType)))
      }

    def convertParams(params: List[List[FunParam]], finalRet: ScalyType): ScalyType = {
      params match {
        case c :: Nil => ScalyFunctionType(Some(convertClause(c)), finalRet)
        case c :: cs => ScalyFunctionType(Some(convertClause(c)), convertParams(cs, finalRet))
        case Nil => ScalyFunctionType(None, finalRet)
      }
    }

    val constructorMembers = constructor.map(_.flatMap {
      case ValClassParam(_, id, typ, _) =>
        Some(id -> Location(ScalyASTPlaceholderType(typ), SymbolSource.MEMBER))
      case VarClassParam(_, id, typ, _) =>
        Some(id -> Location(ScalyASTPlaceholderType(typ), SymbolSource.MEMBER_WRITABLE))
      case _ => None
    })

    (node.body match {
      case Some(ScalyTemplate(stats)) =>
        stats.flatMap {
          case d: Dcl => Some(d match {
            //TODO: declType can be none
            case ValDef(id, Some(declType), _) =>
              id -> Location(ScalyASTPlaceholderType(declType), SymbolSource.MEMBER)
            case VarDef(id, Some(declType), _) =>
              id -> Location(ScalyASTPlaceholderType(declType), SymbolSource.MEMBER_WRITABLE)
            //TODO: Return could be none - inference
            case DefDef(id, params, Some(retType), _) =>
              id -> Location(convertParams(params, ScalyASTPlaceholderType(retType)), SymbolSource.MEMBER)
          })
          case _: Expr => None
        }
      case None => List()
    }) ++ constructorMembers.getOrElse(Nil)
  }.toMap)

  private val _visited: Boolean = false

  override def visited: Boolean = _visited

}

class ScalyASTClassType (
                         val name: String,
                         protected val _parent: Option[ScalyType],
                         val node: ScalyClassDef
                       ) extends ScalyASTTemplateType {


  override def constructor: Option[List[ClassParam]] = Some(node.params)

  override def equals(obj: Any): Boolean = obj match {
    case that: ScalyASTClassType =>
      (that.name == name) && (that.node equals node) && (that.parent equals parent)
    case _ => false
  }

  override def toString: String = s"ClassType($name < $parent)"

}

class ScalyASTObjectType (
                         val name: String,
                         protected val _parent: Option[ScalyType],
                         val node: ScalyObjectDef
                         ) extends ScalyASTTemplateType {

  override def constructor: Option[List[ClassParam]] = Some(Nil)

  override def equals(obj: Any): Boolean = obj match {
    case that: ScalyASTObjectType =>
      (that.name == name) && (that.node equals node) && (that.parent equals parent)
    case _ => false
  }

  override def toString: String = s"ObjectType($name < $parent)"

}

object ScalyASTClassType {

  def apply(name: String, _parent: Option[ScalyType], node: ScalyClassDef): ScalyASTClassType =
    new ScalyASTClassType(name, _parent, node)

  def unapply(arg: ScalyASTClassType): Option[(String, Option[ScalyType], ScalyClassDef)] =
    Some((arg.name, arg.parent, arg.node))


}

object ScalyASTObjectType {

  def apply(name: String, _parent: Option[ScalyType], node: ScalyObjectDef): ScalyASTObjectType =
    new ScalyASTObjectType(name, _parent, node)

  def unapply(arg: ScalyASTObjectType): Option[(String, Option[ScalyType], ScalyObjectDef)] =
    Some((arg.name, arg.parent, arg.node))


}

