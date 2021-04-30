/*
This 200
Vector 100 200 4
100
100 Hello
10 100 20V
None
 */
object Main {

  def main() : Unit = {

    val v1 = Vector(100, 200)
    val v2 = Vector(1, 3)
    val f = new Foo(100, new Bar("Hello", 20))

    v1 match {
      case Vector(1, 200) => print("Not this")
      case Vector(100, b) => print("This " + str(b))
    }

    (v1, v2) match {
      case (x, Vector(a, b)) => print(x.toString + " " + str(a + b))
    }

    f match {
      case Foo(x,y) => print(x)
    }

    print(f match {
      case Foo(a, Bar(x, y)) => str(a) + " " + x
    })

    print((10, f) match {
      case (p, Foo(a, Bar("Hello", (u, v)))) => str(p) + " " + str(a) + " " + str(u) + v
    })

  }

}


class Foo(val a: Int, val b: Bar)

class Bar(val x: String, val y: Int)

object Foo {
  def unapply(arg: Foo): (Int, Bar) = (arg.a, arg.b)
}

object Bar {
  def unapply(arg: Bar): (String, (Int, String)) = (arg.x, (arg.y, "V"))
}


class Vector (val x: Int, val y: Int) {
    def toString: String = "Vector " + str(x) + " " + str(y)
}
object Vector {

  def apply(x: Int, y: Int): Vector = new Vector(x,y)

  def unapply(obj: Vector): (Int, Int) = {
    (obj.x, obj.y)
  }

}