object Main {

  val member = "thing"

  val otherMember = ("thing", 2)

  val thirdMember = 1 + 2

  def main(): Unit = {

    val a = "Hello world"

    def rec(x : Int):Int = if (x == 0) 1 else x + rec(x - 1)

    def innerFunction(x: String) = x + a

    print(innerFunction(a))

    print(a)

    def innerFunction (x: String) = new Wrapper(x + a)

    print(innerFunction("Thing"))

    print(thirdMember)


  }

}

class Wrapper(val x: String) {

  override def toString: String = "Wrapper(" + x + ")"

}