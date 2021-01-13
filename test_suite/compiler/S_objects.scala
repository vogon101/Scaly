/*
Constructing AClass
Constructing AnObject
Building AnObject.x
Constructing AnotherClass with 20
Constructing AnotherObject
129
AnObject Instance
AClass Instance
Constructing AnotherClass with 40
Constructing YetAnotherObject
AnotherClass Instance with 40
None
 */
object Main {

  def main(): Unit = {

    val a: AClass = new AClass
    print(AnObject.foo(AnotherObject))
    print(AnObject)
    print(a)
    print(YetAnotherObject)


  }

}

class AClass {

  print("Constructing AClass")

  def toString(): String = "AClass Instance"

}

object AnObject {

  print("Constructing AnObject")

  val x: String = {
    print("Building AnObject.x")
    "XString"
  }

  def toString(): String = "AnObject Instance"

  def foo(f: AnotherObject): Int = f.x + 10 + f.y

}

class AnotherClass(val y: Int) {

  print("Constructing AnotherClass with " + str(y))
  val x: Int = 99

  def toString(): String = "AnotherClass Instance with " + str(y)

}

object AnotherObject extends AnotherClass(20) {
  print("Constructing AnotherObject")
}

object YetAnotherObject extends AnotherClass(40) {

  print("Constructing YetAnotherObject")

}