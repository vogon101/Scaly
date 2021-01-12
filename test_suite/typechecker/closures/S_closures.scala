class Test {

  def takesAnInt(a: Int): Unit = print(a + 1)

  def foo(): Unit = {

    val a: Int = 100
    val b: String = "String"

    def bar(): Unit = {
      val b: Int = 12
      takesAnInt(a)
      takesAnInt(b)
    }

    bar()

  }

}