class Test {

  def test(): Int =
    (1, "String") match {
      case (x, y) =>
        isInt(y)
    }

  def isInt(y: Int): Int = y



}