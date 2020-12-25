package com.freddieposer.scaly.typechecker.types

object SymbolSource extends Enumeration {

  type SymbolSource = Value

  val LOCAL, MEMBER, GLOBAL, THIS = Value

}
