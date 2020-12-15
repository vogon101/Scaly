package com.freddieposer.scaly.typechecker

object Variance extends Enumeration {

  protected case class Val() extends super.Val {
    def flip: Variance = this match {
      case CONTRA => CO
      case CO => CONTRA
      case IN => IN
    }
  }

  type Variance = Val


  val IN, CO, CONTRA = Val()
}
