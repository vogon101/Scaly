class A {

  def mName: Boolean = true

  def foo(name: String): String = {
    mName
//    thing(name)
    name
  }

  def things: Boolean = foo2("Test")(100)
  def x: Int => String = foo2("Freddie")

  def foo2(name1: String)(name2: Int): String = {
    name1
  }

//  def thing(x: String): Unit = 100


}

class B

class C extends A