class Test {

  def takesAnInt(a: Int): Unit = print(a + 1)

  val member: String = "I am a member"

  def foo(): Unit = {

    val a: Int = 100
    val b: String = "String"
    var counter: Int = 0

    def bar(): Unit = {
      counter = counter + 1
      //TODO: forward reference extends over definition of value x
      //print(b) - should throw error
      val b: Int = 12
      takesAnInt(a)
      takesAnInt(b)
      print(">> " + member)
    }

    bar()

  }

}