package com.freddieposer.scaly.typechecker

object Utils {

  implicit class ListOfEithers[L, R](val xs: List[Either[L, R]]) extends AnyRef {

    def toList: List[Either[L, R]] = xs

    def collapse: Either[L, List[R]] = xs.partition(_.isLeft) match {
      case (Nil, rights) => Right(for (Right(t) <- rights) yield t)
      case (Left(e) :: _, _) => Left(e)
    }

  }

  implicit class ExtendedListEither[L, R](val xs: Either[L, List[Either[L, R]]]) {
    def collapse: Either[L, List[R]] =
      xs match {
        case Left(value) => Left(value)
        case Right(es) => es.collapse
      }
  }

  implicit class ExtendedEither[L, R](val xs: Either[L, Either[L, R]]) {
    def collapse: Either[L, R] =
      xs match {
        case Left(value) => Left(value)
        case Right(Left(e)) => Left(e)
        case Right(Right(v)) => Right(v)
      }
  }

}
