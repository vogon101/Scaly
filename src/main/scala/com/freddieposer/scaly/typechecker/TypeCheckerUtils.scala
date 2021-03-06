package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.ScalyAST
import com.freddieposer.scaly.typechecker.types.ScalyType

object TypeCheckerUtils {

  type UR = Either[UnificationFailure, UnificationSuccess]
  type TCR[+T] = Either[TypeError, T]

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

  implicit class ExtendedTCR[T](tcr: TCR[T]) {

    def mapError(t1: ScalyType, t2: ScalyType): Either[UnificationFailure, T] =
      tcr.left.map(e => new UnificationFailureFromTypeCheck(t1, t2, e)(e.ctx))

  }

  implicit class ExtendedUR(ur: UR) {

    def mapError(node: ScalyAST): Either[TypeError, UnificationSuccess] =
      ur.left.map(e => new TypeErrorFromUnificationFailure(e, node)(e.ctx))

  }

}
