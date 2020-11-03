package com.freddieposer.scaly.backend.pyc.defs

object PycTypeBytes {

  type TypeByte = Char

  val TYPE_NULL            : TypeByte    =   '0'
  val TYPE_NONE            : TypeByte    =   'N'
  val TYPE_FALSE           : TypeByte    =   'F'
  val TYPE_TRUE            : TypeByte    =   'T'
  val TYPE_STOPITER        : TypeByte    =   'S'
  val TYPE_ELLIPSIS        : TypeByte    =   '.'
  val TYPE_INT             : TypeByte    =   'i'
  /* TYPE_INT64 is not gene: TypeByte    =rated anymore.
     Supported for backward: TypeByte    = compatibility only. */
  val TYPE_INT64           : TypeByte    =   'I'
  val TYPE_FLOAT           : TypeByte    =   'f'
  val TYPE_BINARY_FLOAT    : TypeByte    =   'g'
  val TYPE_COMPLEX         : TypeByte    =   'x'
  val TYPE_BINARY_COMPLEX  : TypeByte    =   'y'
  val TYPE_LONG            : TypeByte    =   'l'
  val TYPE_STRING          : TypeByte    =   's'
  val TYPE_INTERNED        : TypeByte    =   't'
  val TYPE_REF             : TypeByte    =   'r'
  val TYPE_TUPLE           : TypeByte    =   '('
  val TYPE_LIST            : TypeByte    =   '['
  val TYPE_DICT            : TypeByte    =   '{'
  val TYPE_CODE            : TypeByte    =   'c'
  val TYPE_UNICODE         : TypeByte    =   'u'
  val TYPE_UNKNOWN         : TypeByte    =   '?'
  val TYPE_SET             : TypeByte    =   '<'
  val TYPE_FROZENSET       : TypeByte    =   '>'
  val FLAG_REF             : TypeByte    =   0x80/* with a type, add obj to index */

  val TYPE_ASCII           : TypeByte    =   'a'
  val TYPE_ASCII_INTERNED  : TypeByte    =   'A'
  val TYPE_SMALL_TUPLE     : TypeByte    =   ')'
  val TYPE_SHORT_ASCII     : TypeByte    =   'z'
  val TYPE_SHORT_ASCII_INTERNED : TypeByte    = 'Z'


}
