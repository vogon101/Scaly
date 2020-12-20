package com.freddieposer.scaly.backend.internal

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

//TODO: defs without application
case class IST_FunctionCall(
                      lhs: IST_Expression,
                      rhs: IST_Expression
                      ) extends IST_Expression

case class IST_If(
                 cond: IST_Expression,
                 tBranch: IST_Expression,
                 fBranch: Option[IST_Expression]
                 ) extends IST_Expression

abstract class IST_Literal extends IST_Expression

case class IST_Block(statements: List[IST_Statement]) extends IST_Expression