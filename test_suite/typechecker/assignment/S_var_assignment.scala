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

    (new MyThing("Name1")).rename("This is a new name")

    x
  }

}

class A
class B extends A
class C extends B

class MyThing (var name: String) {

  def rename(newName: String): Unit = name = newName

}