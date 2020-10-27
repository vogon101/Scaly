package com.freddieposer.scaly.backend.pyc.defs

object PycTypeBytes {

  val TYPE_NULL            =   '0'
  val TYPE_NONE            =   'N'
  val TYPE_FALSE           =   'F'
  val TYPE_TRUE            =   'T'
  val TYPE_STOPITER        =   'S'
  val TYPE_ELLIPSIS        =   '.'
  val TYPE_INT             =   'i'
  /* TYPE_INT64 is not gene=rated anymore.
     Supported for backward= compatibility only. */
  val TYPE_INT64           =   'I'
  val TYPE_FLOAT           =   'f'
  val TYPE_BINARY_FLOAT    =   'g'
  val TYPE_COMPLEX         =   'x'
  val TYPE_BINARY_COMPLEX  =   'y'
  val TYPE_LONG            =   'l'
  val TYPE_STRING          =   's'
  val TYPE_INTERNED        =   't'
  val TYPE_REF             =   'r'
  val TYPE_TUPLE           =   '('
  val TYPE_LIST            =   '['
  val TYPE_DICT            =   '{'
  val TYPE_CODE            =   'c'
  val TYPE_UNICODE         =   'u'
  val TYPE_UNKNOWN         =   '?'
  val TYPE_SET             =   '<'
  val TYPE_FROZENSET       =   '>'
  val FLAG_REF: Char       =   0x80/* with a type, add obj to index */

  val TYPE_ASCII           =   'a'
  val TYPE_ASCII_INTERNED  =   'A'
  val TYPE_SMALL_TUPLE     =   ')'
  val TYPE_SHORT_ASCII     =   'z'
  val TYPE_SHORT_ASCII_INTERNED = 'Z'


}
