package com.freddieposer.scaly.typechecker.types

object SymbolSource extends Enumeration {

  type SymbolSource = Value

  //Globals assumed to be non-writable
  val LOCAL, LOCAL_WRITABLE, MEMBER, MEMBER_WRITABLE, GLOBAL, THIS = Value

  def isWritable(ss: SymbolSource): Boolean = ss match {
    case LOCAL_WRITABLE | MEMBER_WRITABLE => true
    case _ => false
  }

  def writable(ss: SymbolSource): Option[SymbolSource] = ss match {
    case LOCAL_WRITABLE | MEMBER_WRITABLE => Some(ss)
    case LOCAL => Some(LOCAL_WRITABLE)
    case MEMBER => Some(MEMBER_WRITABLE)
    case _ => None
  }


}
