package com.freddieposer.scaly.typechecker

object Variance extends Enumeration {

  type Variance = Val
  val IN, CO, CONTRA = Val()

  protected case class Val() extends super.Val {
    def flip: Variance = this match {
      case CONTRA => CO
      case CO => CONTRA
      case IN => IN
    }
  }

}
