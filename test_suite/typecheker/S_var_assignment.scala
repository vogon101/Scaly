class Foo {

  var memberVar: Int = 100

  var myA: A = new A
  var myB: B = new B

  def foo(): String = {
    var x: String = "This is a string"

    memberVar = 1000
    x = "This is another string"

    myA = new B
    myA = new C
    myB = new C

    x
  }

}

class A
class B extends A
class C extends B