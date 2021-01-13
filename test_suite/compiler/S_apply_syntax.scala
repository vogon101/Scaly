/*
This is A
This is A
None
 */
object Main {

  def main(): Unit = {

    val a = new A
    val b = new B
    a()
    b()()


  }

}

class A {

  def apply(): Unit = {

    print("This is A")

  }

}

class B {

  def apply(): A = new A

}