class A {

  def mName: Boolean = true

  def foo(name: String): Boolean = {
    mName
//    thing(name)
    name
    mName
  }

  def things: String = foo2("Test")(100)
  //TODO: Application to a paramaterless function
//  def x: Int => String = foo2("Freddie")
  def x(y: Int): String = foo2("Freddie")(y)

//  def mInt: Int = "String"

  def foo2(name1: String)(name2: Int): String = {
    name1
  }


  def partialApp: String = x(10)

  def otherThing: Boolean = this.mName

//  def mB: B = new B

  def useB(b: B): Int = {
    b.thing(this)
    10
  }

//  def thing(x: String): Unit = 100


}

class B {

  def thing(a: A): String = {

    a.partialApp

  }

}

class C extends A