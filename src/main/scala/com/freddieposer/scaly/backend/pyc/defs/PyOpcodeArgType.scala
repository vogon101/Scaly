package com.freddieposer.scaly.backend.pyc.defs

object PyOpcodeArgType extends Enumeration {

  type PyOpcodeArgType = Value

  val OTHER,
      IDX_NAME_LIST,
      IDX_CONST_LIST,
      ADDRESS,
      ADDRESS_DISTANCE,
      LOCAL_VAR_NUM
  = Value

}
