package com.freddieposer.scaly.backend.internal

import com.freddieposer.scaly.backend.pyc.PyObject

/*
TODO: This should form part of the type check process so that these have the types with them. This then
  allows for things like select of defs to be done correctly.
  Could possibly use @property to deal with that? - may handle behind the scenes
 */
class IST

class IST_CompilationUnit(val classes: List[IST_Class]) extends IST

case class IST_Class(
                      name: String,
                      valMembers: Map[String, IST_Expression],
                      varMembers: Map[String, IST_Expression],
                      defMembers: Map[String, IST_Function]
                    ) extends IST

sealed abstract class IST_Statement extends IST

sealed abstract class IST_Expression extends IST_Statement

case class IST_Function(
                         args: List[String],
                         body: IST_Expression
                       ) extends IST_Expression

//TODO: defs without application - perhaps could use the @property
case class IST_FunctionCall(
                             lhs: IST_Expression,
                             rhs: IST_Expression
                           ) extends IST_Expression

case class IST_If(
                   cond: IST_Expression,
                   tBranch: IST_Expression,
                   fBranch: Option[IST_Expression]
                 ) extends IST_Expression

case class IST_Literal(py: PyObject) extends IST_Expression

case class IST_Block(statements: List[IST_Statement]) extends IST_Expression

case class IST_Application(lhs: IST_Expression, args: List[IST_Expression]) extends IST_Expression

//TODO: This transformation should be used in future for the various types
//  e.g. when the arm selected is a def
case class IST_Select(lhs: IST_Expression, rhs: String) extends IST_Expression