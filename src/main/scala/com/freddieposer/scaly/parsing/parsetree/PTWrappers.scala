package com.freddieposer.scaly.parsing.parsetree

/**
 * Classes that wrap objects as {@link ParseTree} instances as well as utility functions
 */
object PTWrappers {

  implicit def WrapParseTreeList[T <: ParseTree](xs: List[T]): PTSeq[T] = new PTSeq[T](xs)

  implicit def UnwrapParseTreeList[T <: ParseTree](xs: PTSeq[T]): List[T] = xs.elems

  implicit def WrapParseTreeOption[T <: ParseTree](x: Option[T]): PTOpt[T] = PTOpt(x)

  implicit def UnwrapParseTreeOption[T <: ParseTree](x: PTOpt[T]): Option[T] = x.toOption

  final class PTSeq[+T <: ParseTree](val elems: List[T]) extends ParseTree with Seq[T] {
    override def apply(i: Int): T = elems(i)

    override def length: Int = elems.length

    override def iterator: Iterator[T] = elems.iterator
  }

  object PTSeq {

    def apply[T <: ParseTree](elems: T*): PTSeq[T] = new PTSeq(elems.toList)

  }

  sealed abstract class PTOpt[+T <: ParseTree] extends ParseTree {

    def map[B <: ParseTree](f: T => B): PTOpt[B]

    def toOption: Option[T]

  }

  object PTOpt {

    def apply[T <: ParseTree](value: T): PTOpt[T] =
      value match {
        case null => PTNone
        case _ => PTSome(value)
      }

    def apply[T <: ParseTree](value: Option[T]): PTOpt[T] =
      value match {
        case Some(x) => PTSome(x)
        case None => PTNone
      }

  }

  final case class PTSome[+T <: ParseTree](value: T) extends PTOpt[T] {
    override def map[B <: ParseTree](f: T => B): PTOpt[B] = PTSome(f(value))

    override def toOption: Option[T] = Some(value)
  }

  final case object PTNone extends PTOpt {
    override def map[B <: ParseTree](f: Nothing => B): PTOpt[B] = PTNone

    override def toOption: Option[Nothing] = None
  }

}

