class Test {

  def test(): Unit = {

    (new A)()

    print("")
  }

}

class A {

  val apply: Int = 100

}