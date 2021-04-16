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
Constructing Vector Companion Object
Vector 1 2
Vector 9 10
Vector 10 12
Vector 9 11
11
19
None
 */
object Main {

  def main(): Unit = {

    val a: AClass = new AClass
    print(AnObject.foo(AnotherObject))
    print(AnObject)
    print(a)
    print(YetAnotherObject)

    val v1 = Vector(1,2)
    val v2 = Vector(9, 10)

    print(v1)
    print(v2)
    print(v1 + v2)
    print(Vector bar v2)
    print(v1.foo(10))
    print(v2.foo(10))

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

class Vector (val x: Int, val y: Int) {

  def foo(z: Int): Int = z + x

  def toString: String = "Vector " + str(x) + " " + str(y)

  def + (that: Vector): Vector = Vector(x + that.x, y + that.y)

}

object Vector {

  print("Constructing Vector Companion Object")

  def apply(x: Int, y: Int): Vector = new Vector(x,y)

  def bar(v: Vector): Vector = v + Vector (0, 1)

}