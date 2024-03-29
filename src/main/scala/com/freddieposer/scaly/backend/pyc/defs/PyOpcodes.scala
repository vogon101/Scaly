package com.freddieposer.scaly.backend.pyc.defs

import com.freddieposer.scaly.backend.pyc.defs.PyOpcodeArgType.PyOpcodeArgType

object PyOpcodes extends Enumeration {

  type PyOpcode = Val
  final val POP_TOP = Val(1)
  final val ROT_TWO = Val(2)
  final val ROT_THREE = Val(3)
  final val DUP_TOP = Val(4)
  final val DUP_TOP_TWO = Val(5)
  final val NOP = Val(9)
  final val UNARY_POSITIVE = Val(10)
  final val UNARY_NEGATIVE = Val(11)
  final val UNARY_NOT = Val(12)
  final val UNARY_INVERT = Val(15)
  final val BINARY_MATRIX_MULTIPLY = Val(16)
  final val INPLACE_MATRIX_MULTIPLY = Val(17)
  final val BINARY_POWER = Val(19)
  final val BINARY_MULTIPLY = Val(20)
  final val BINARY_MODULO = Val(22)
  final val BINARY_ADD = Val(23)
  final val BINARY_SUBTRACT = Val(24)
  final val BINARY_SUBSCR = Val(25)
  final val BINARY_FLOOR_DIVIDE = Val(26)
  final val BINARY_TRUE_DIVIDE = Val(27)
  final val INPLACE_FLOOR_DIVIDE = Val(28)
  final val INPLACE_TRUE_DIVIDE = Val(29)
  final val GET_AITER = Val(50)
  final val GET_ANEXT = Val(51)
  final val BEFORE_ASYNC_WITH = Val(52)
  final val INPLACE_ADD = Val(55)
  final val INPLACE_SUBTRACT = Val(56)
  final val INPLACE_MULTIPLY = Val(57)
  final val INPLACE_MODULO = Val(59)
  final val STORE_SUBSCR = Val(60)
  final val DELETE_SUBSCR = Val(61)
  final val BINARY_LSHIFT = Val(62)
  final val BINARY_RSHIFT = Val(63)
  final val BINARY_AND = Val(64)
  final val BINARY_XOR = Val(65)
  final val BINARY_OR = Val(66)
  final val INPLACE_POWER = Val(67)
  final val GET_ITER = Val(68)
  final val GET_YIELD_FROM_ITER = Val(69)
  final val PRINT_EXPR = Val(70)
  final val LOAD_BUILD_CLASS = Val(71)
  final val YIELD_FROM = Val(72)
  final val GET_AWAITABLE = Val(73)
  final val INPLACE_LSHIFT = Val(75)
  final val INPLACE_RSHIFT = Val(76)
  final val INPLACE_AND = Val(77)
  final val INPLACE_XOR = Val(78)
  final val INPLACE_OR = Val(79)
  final val BREAK_LOOP = Val(80)
  final val WITH_CLEANUP_START = Val(81)
  final val WITH_CLEANUP_FINISH = Val(82)
  final val RETURN_VALUE = Val(83)
  final val IMPORT_STAR = Val(84)
  final val SETUP_ANNOTATIONS = Val(85)
  final val YIELD_VALUE = Val(86)
  final val POP_BLOCK = Val(87)
  final val END_FINALLY = Val(88)
  final val POP_EXCEPT = Val(89)
  final val STORE_NAME = Val(90, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val DELETE_NAME = Val(91, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val UNPACK_SEQUENCE = Val(92)
  final val FOR_ITER = Val(93)
  final val UNPACK_EX = Val(94)
  final val STORE_ATTR = Val(95, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val DELETE_ATTR = Val(96, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val STORE_GLOBAL = Val(97, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val DELETE_GLOBAL = Val(98, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val LOAD_CONST = Val(100, Some(PyOpcodeArgType.IDX_CONST_LIST))
  final val LOAD_NAME = Val(101, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val BUILD_TUPLE = Val(102)
  final val BUILD_LIST = Val(103)
  final val BUILD_SET = Val(104)
  final val BUILD_MAP = Val(105)
  final val LOAD_ATTR = Val(106, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val COMPARE_OP = Val(107)
  final val IMPORT_NAME = Val(108, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val IMPORT_FROM = Val(109)
  final val JUMP_FORWARD = Val(110)
  final val JUMP_IF_FALSE_OR_POP = Val(111)
  final val JUMP_IF_TRUE_OR_POP = Val(112)
  final val JUMP_ABSOLUTE = Val(113)
  final val POP_JUMP_IF_FALSE = Val(114)
  final val POP_JUMP_IF_TRUE = Val(115)
  final val LOAD_GLOBAL = Val(116, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val CONTINUE_LOOP = Val(119)
  final val SETUP_LOOP = Val(120)
  final val SETUP_EXCEPT = Val(121)
  final val SETUP_FINALLY = Val(122)
  final val LOAD_FAST = Val(124, Some(PyOpcodeArgType.LOCAL_VAR_NUM))
  final val STORE_FAST = Val(125, Some(PyOpcodeArgType.LOCAL_VAR_NUM))
  final val DELETE_FAST = Val(126)
  final val RAISE_VARARGS = Val(130)
  final val CALL_FUNCTION = Val(131)
  final val MAKE_FUNCTION = Val(132)
  final val BUILD_SLICE = Val(133)
  final val LOAD_CLOSURE = Val(135, Some(PyOpcodeArgType.IDX_CELL))
  final val LOAD_DEREF = Val(136, Some(PyOpcodeArgType.IDX_CELL))
  final val STORE_DEREF = Val(137, Some(PyOpcodeArgType.IDX_CELL))
  final val DELETE_DEREF = Val(138, Some(PyOpcodeArgType.IDX_CELL))
  final val CALL_FUNCTION_KW = Val(141)
  final val CALL_FUNCTION_EX = Val(142)
  final val SETUP_WITH = Val(143)
  final val EXTENDED_ARG = Val(144)
  final val LIST_APPEND = Val(145)
  final val SET_ADD = Val(146)
  final val MAP_ADD = Val(147)
  final val LOAD_CLASSDEREF = Val(148)
  final val BUILD_LIST_UNPACK = Val(149)
  final val BUILD_MAP_UNPACK = Val(150)
  final val BUILD_MAP_UNPACK_WITH_CALL = Val(151)
  final val BUILD_TUPLE_UNPACK = Val(152)
  final val BUILD_SET_UNPACK = Val(153)
  final val SETUP_ASYNC_WITH = Val(154)
  final val FORMAT_VALUE = Val(155)
  final val BUILD_CONST_KEY_MAP = Val(156)
  final val BUILD_STRING = Val(157)
  final val BUILD_TUPLE_UNPACK_WITH_CALL = Val(158)
  final val LOAD_METHOD = Val(160, Some(PyOpcodeArgType.IDX_NAME_LIST))
  final val CALL_METHOD = Val(161)
  lazy val valueList: List[Val] = values.toList.asInstanceOf[List[Val]]
  lazy val opcodeMap: Map[Int, Val] = valueList.map(value => (value.opcode, value)).toMap

  protected case class Val(opcode: Int, argType: Option[PyOpcodeArgType] = None) extends super.Val {
    def takesArg: Boolean = opcode >= 90

    def byte: Byte = (opcode & 0xff).toByte
  }

}
