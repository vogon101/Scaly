package com.freddieposer.scaly.backend.pyc.defs

import com.freddieposer.scaly.backend.pyc.defs.PyOpcodeArgType.PyOpcodeArgType

object PyOpcodes extends Enumeration {

  protected case class Val(opcode: Int, argType: Option[PyOpcodeArgType] = None) extends super.Val {
    def takesArg: Boolean = opcode >= 90

    def byte: Byte = (opcode & 0xff).toByte
  }

  type PyOpcode = Val

  lazy val valueList: List[Val] = values.toList.asInstanceOf[List[Val]]
  lazy val opcodeMap: Map[Int, Val] = valueList.map(value => (value.opcode, value)).toMap

  val POP_TOP: Val = Val(1)
  val ROT_TWO: Val = Val(2)
  val ROT_THREE: Val = Val(3)
  val DUP_TOP: Val = Val(4)
  val DUP_TOP_TWO: Val = Val(5)
  val NOP: Val = Val(9)
  val UNARY_POSITIVE: Val = Val(10)
  val UNARY_NEGATIVE: Val = Val(11)
  val UNARY_NOT: Val = Val(12)
  val UNARY_INVERT: Val = Val(15)
  val BINARY_MATRIX_MULTIPLY: Val = Val(16)
  val INPLACE_MATRIX_MULTIPLY: Val = Val(17)
  val BINARY_POWER: Val = Val(19)
  val BINARY_MULTIPLY: Val = Val(20)
  val BINARY_MODULO: Val = Val(22)
  val BINARY_ADD: Val = Val(23)
  val BINARY_SUBTRACT: Val = Val(24)
  val BINARY_SUBSCR: Val = Val(25)
  val BINARY_FLOOR_DIVIDE: Val = Val(26)
  val BINARY_TRUE_DIVIDE: Val = Val(27)
  val INPLACE_FLOOR_DIVIDE: Val = Val(28)
  val INPLACE_TRUE_DIVIDE: Val = Val(29)
  val GET_AITER: Val = Val(50)
  val GET_ANEXT: Val = Val(51)
  val BEFORE_ASYNC_WITH: Val = Val(52)
  val INPLACE_ADD: Val = Val(55)
  val INPLACE_SUBTRACT: Val = Val(56)
  val INPLACE_MULTIPLY: Val = Val(57)
  val INPLACE_MODULO: Val = Val(59)
  val STORE_SUBSCR: Val = Val(60)
  val DELETE_SUBSCR: Val = Val(61)
  val BINARY_LSHIFT: Val = Val(62)
  val BINARY_RSHIFT: Val = Val(63)
  val BINARY_AND: Val = Val(64)
  val BINARY_XOR: Val = Val(65)
  val BINARY_OR: Val = Val(66)
  val INPLACE_POWER: Val = Val(67)
  val GET_ITER: Val = Val(68)
  val GET_YIELD_FROM_ITER: Val = Val(69)
  val PRINT_EXPR: Val = Val(70)
  val LOAD_BUILD_CLASS: Val = Val(71)
  val YIELD_FROM: Val = Val(72)
  val GET_AWAITABLE: Val = Val(73)
  val INPLACE_LSHIFT: Val = Val(75)
  val INPLACE_RSHIFT: Val = Val(76)
  val INPLACE_AND: Val = Val(77)
  val INPLACE_XOR: Val = Val(78)
  val INPLACE_OR: Val = Val(79)
  val BREAK_LOOP: Val = Val(80)
  val WITH_CLEANUP_START: Val = Val(81)
  val WITH_CLEANUP_FINISH: Val = Val(82)
  val RETURN_VALUE: Val = Val(83)
  val IMPORT_STAR: Val = Val(84)
  val SETUP_ANNOTATIONS: Val = Val(85)
  val YIELD_VALUE: Val = Val(86)
  val POP_BLOCK: Val = Val(87)
  val END_FINALLY: Val = Val(88)
  val POP_EXCEPT: Val = Val(89)
  val STORE_NAME: Val = Val(90, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val DELETE_NAME: Val = Val(91, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val UNPACK_SEQUENCE: Val = Val(92)
  val FOR_ITER: Val = Val(93)
  val UNPACK_EX: Val = Val(94)
  val STORE_ATTR: Val = Val(95, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val DELETE_ATTR: Val = Val(96, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val STORE_GLOBAL: Val = Val(97, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val DELETE_GLOBAL: Val = Val(98, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val LOAD_CONST: Val = Val(100, Some(PyOpcodeArgType.IDX_CONST_LIST))
  val LOAD_NAME: Val = Val(101, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val BUILD_TUPLE: Val = Val(102)
  val BUILD_LIST: Val = Val(103)
  val BUILD_SET: Val = Val(104)
  val BUILD_MAP: Val = Val(105)
  val LOAD_ATTR: Val = Val(106, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val COMPARE_OP: Val = Val(107)
  val IMPORT_NAME: Val = Val(108)
  val IMPORT_FROM: Val = Val(109)
  val JUMP_FORWARD: Val = Val(110)
  val JUMP_IF_FALSE_OR_POP: Val = Val(111)
  val JUMP_IF_TRUE_OR_POP: Val = Val(112)
  val JUMP_ABSOLUTE: Val = Val(113)
  val POP_JUMP_IF_FALSE: Val = Val(114)
  val POP_JUMP_IF_TRUE: Val = Val(115)
  val LOAD_GLOBAL: Val = Val(116, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val CONTINUE_LOOP: Val = Val(119)
  val SETUP_LOOP: Val = Val(120)
  val SETUP_EXCEPT: Val = Val(121)
  val SETUP_FINALLY: Val = Val(122)
  val LOAD_FAST: Val = Val(124, Some(PyOpcodeArgType.LOCAL_VAR_NUM))
  val STORE_FAST: Val = Val(125)
  val DELETE_FAST: Val = Val(126)
  val RAISE_VARARGS: Val = Val(130)
  val CALL_FUNCTION: Val = Val(131)
  val MAKE_FUNCTION: Val = Val(132)
  val BUILD_SLICE: Val = Val(133)
  val LOAD_CLOSURE: Val = Val(135)
  val LOAD_DEREF: Val = Val(136)
  val STORE_DEREF: Val = Val(137)
  val DELETE_DEREF: Val = Val(138)
  val CALL_FUNCTION_KW: Val = Val(141)
  val CALL_FUNCTION_EX: Val = Val(142)
  val SETUP_WITH: Val = Val(143)
  val EXTENDED_ARG: Val = Val(144)
  val LIST_APPEND: Val = Val(145)
  val SET_ADD: Val = Val(146)
  val MAP_ADD: Val = Val(147)
  val LOAD_CLASSDEREF: Val = Val(148)
  val BUILD_LIST_UNPACK: Val = Val(149)
  val BUILD_MAP_UNPACK: Val = Val(150)
  val BUILD_MAP_UNPACK_WITH_CALL: Val = Val(151)
  val BUILD_TUPLE_UNPACK: Val = Val(152)
  val BUILD_SET_UNPACK: Val = Val(153)
  val SETUP_ASYNC_WITH: Val = Val(154)
  val FORMAT_VALUE: Val = Val(155)
  val BUILD_CONST_KEY_MAP: Val = Val(156)
  val BUILD_STRING: Val = Val(157)
  val BUILD_TUPLE_UNPACK_WITH_CALL: Val = Val(158)
  val LOAD_METHOD: Val = Val(160, Some(PyOpcodeArgType.IDX_NAME_LIST))
  val CALL_METHOD: Val = Val(161)

}