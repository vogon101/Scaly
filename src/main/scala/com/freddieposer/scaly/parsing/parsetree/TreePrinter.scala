package com.freddieposer.scaly.parsing.parsetree

trait HasToStringTree {

  def toStringTree: StringTree

}

sealed abstract class StringTree {

  def prettyPrint(indent: Int = 0):String

}

object StringTree {

  def fromIndexedList(name: String, is: List[HasToStringTree]): StringTree =
    StringTreeNode(name, is.zipWithIndex.map{case (v, i) => (i.toString, v.toStringTree)})

  implicit def StringToStringTree(v: String): StringTreeStringLeaf =
    StringTreeStringLeaf(v)

  implicit def StringOptionToStringTree(v: Option[String]): StringTreeStringLeaf =
    StringTreeStringLeaf(v.getOrElse("None"))

  implicit def OptionToStringTree(v: Option[HasToStringTree]): StringTree =
    v.map(_.toStringTree).getOrElse("None")

}

case class StringTreeNode(name: String, nodes: List[(String, StringTree)]) extends StringTree {

  override def toString: String =
    f"$name (${nodes.map(x => x._1 + ": " + x._2).mkString(", ")})"

  def prettyPrint(indent: Int = 0):String =
    f"""$name
       |${nodes.map{ case (n,v) => f"\t$n => ${v.prettyPrint(1)}" }.mkString("\n")}
       |""".stripMargin.split("\n").map(("\t" * indent) + _).mkString("\n")

}

case class StringTreeLeaf(name: String, members: List[(String, String)]) extends StringTree {

  override def toString: String =
    f"$name (${members.map(x => x._1 + ": " + x._2).mkString(", ")})"

  def prettyPrint(indent: Int = 0):String =
    f"""$name
       |${members.map{ case (n,v) => f"\t$n : $v"}.mkString("\n")}
       |""".stripMargin.split("\n").map(("\t" * indent) + _).mkString("\n")

}

case class StringTreeStringLeaf(value: String) extends StringTree {

  override def toString: String = value

  override def prettyPrint(indent: Int): String = ("\t" * indent) + value

}