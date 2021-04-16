object Main {

  def main() : Unit = {

//    val v = Vector(1, 2)
//    print(Vector.unapply(v))
//
//    print(v match {
//      case Vector(1, y) => y + 1
//    })
//
//    print( (10,2) match {
//      case (x, y) => x + y
//    })

    val f = new Foo(100, new Bar("Hello", 20))

    print(f match {
      case Foo(x,y) => print(y)
    })

    print(f match {
      case Foo(a, Bar(x, y)) => print(x)
    })

    print((10, f) match {
      case (p, Foo(a, Bar("Hello", (u, v)))) => v
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
//  def toString: String = "Vector " + str(x) + " " + str(y)

}
object Vector {

  def apply(x: Int, y: Int): Vector = new Vector(x,y)

  def unapply(obj: Vector): (Int, Int) = {
    print("Unapply " + str(obj))
    (obj.x, obj.y)
  }

}