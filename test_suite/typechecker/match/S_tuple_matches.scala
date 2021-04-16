class Foo {

  def foo(in: Int): (Int, String) = {

    val x = (in, "Freddie") match {

      case (a, "Tobias") => a + 10
      case (a, "Freddie") => a + 100
      case a => a._1 + 1000

    }

    val y = (in, x, ("String", "String")) match {
      case (a, b, ("Int", c)) =>
        isInt(a)
        isInt(b)
        isString(c)
      case (a, b, ("String", c)) =>
        isInt(a)
        isInt(b)
        isString(c)
    }

    val res = x match {

      case 20 => (in, "20!")
      case 120 => (in, "120!")
      case z => (in, str(z * 2) + "!")

    }

  }

  def isString(x: String): String = x
  def isInt(x: Int): Int = x

}