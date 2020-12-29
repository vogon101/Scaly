class Test {

  def foo(x: A): String = {

    x()

  }

}

class A {

  def apply(): String = "This is a string"

}