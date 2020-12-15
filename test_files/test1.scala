class A {

  val my_static_string: String = "This is a string"
  var my_var_string: String = "This is a string also"

  val thingThing: String = my_static_string
  val notThing: Int = {
    my_static_string
    10
  }

  def function(parameter: String): Int = {

    my_var_string
    10

  }

  def function2(parameter: String): Int = {
    function(my_static_string)
  }

  def recursive(n: String): Int = {
    recursive("this")
  }

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

  def toStringTest():String = {
    (100).toString()
  }

  def useC(c: C): String = c.x(100)

  def useC2(c: C): String = c.foo2(c.x(101))(20)

  def useC3(c: C): String = c.toString

  def varianceTest(b: B): Boolean = this equals b

//  def thing(x: String): Unit = 100

  def variances(d: Dog)(f: Animal => Dog): Animal = f(d)

  def variancesAgain(p: Puppy)(f2: Object => Puppy): Object = variances(p)(f2)

  def operatorTest(v1: Vector, v2: Vector): Object = v1 + v2

  def additionTest: String = (100 + 20.0.toInt).toString

  def nullTest(f: Int => String => Dog => Cat): Animal = {
    f(null)(null)(null)
  }

}

class B {

  def thing(a: A): String = {

    a.partialApp

  }

}

class C extends A

class Animal
class Dog extends Animal
class Cat extends Animal
class Puppy extends Dog

class Vector {

  def +(that: Vector): Vector = this + that

}