package com.freddieposer.scaly.typechecker.types

object SymbolSource extends Enumeration {

  type SymbolSource = Value

  //Globals assumed to be non-writable
  val LOCAL, LOCAL_WRITABLE,
  MEMBER, MEMBER_WRITABLE,
  GLOBAL, GLOBAL_LAZY, THIS,
  CLOSURE, CLOSURE_WRITABLE,
  CLOSURE_MEMBER, CLOSURE_MEMBER_WRITABLE = Value

  def isWritable(ss: SymbolSource): Boolean = ss match {
    case LOCAL_WRITABLE | MEMBER_WRITABLE | CLOSURE_WRITABLE => true
    case _ => false
  }

  def writable(ss: SymbolSource): Option[SymbolSource] = ss match {
    case LOCAL_WRITABLE | MEMBER_WRITABLE | CLOSURE_WRITABLE | CLOSURE_MEMBER_WRITABLE => Some(ss)
    case LOCAL => Some(LOCAL_WRITABLE)
    case MEMBER => Some(MEMBER_WRITABLE)
    case CLOSURE => Some(CLOSURE_WRITABLE)
    case CLOSURE_MEMBER => Some(CLOSURE_MEMBER_WRITABLE)
    case _ => None
  }

  def nonWritable(ss: SymbolSource): SymbolSource = ss match {
    case LOCAL_WRITABLE => LOCAL
    case MEMBER_WRITABLE => MEMBER
    case CLOSURE_MEMBER_WRITABLE => CLOSURE_MEMBER
    case CLOSURE_WRITABLE => CLOSURE
    case _ => ss
  }

  def asClosure(ss: SymbolSource): SymbolSource = ss match {
    case LOCAL => CLOSURE
    case LOCAL_WRITABLE => CLOSURE_WRITABLE
    case MEMBER => CLOSURE_MEMBER
    case MEMBER_WRITABLE => CLOSURE_MEMBER_WRITABLE
    case GLOBAL | GLOBAL_LAZY | THIS => ???
    case _ => ss
  }

  def localClosure(ss: SymbolSource): SymbolSource = ss match {
    case LOCAL | LOCAL_WRITABLE => asClosure(ss)
    case _ => ss
  }


}
