/*
Vector (100, 200)
Vector (100, 200)
Vector (0, 0)
Vector (-100, -300)
Not Thing
Vector Equals
Yes!
Vector Equals
!
None
 */
object Main {

  def main(): Unit = {

    def z(v: Vector): Boolean = v.x == v.y

    val v1 = new Vector(100, 200)

    print(v1 + ZeroVector)
    print(-ZeroVector + v1)
    print(-v1 + v1)
    print(-v1 + -(new Vector(0, 100)))
    if (z(-v1)) {
      print("Thing")
    } else {
      print("Not Thing")
    }

    if (-v1 + Vector(1, 2)  == Vector(-99, -198))
      print("Yes!")

    if (v1 == "String")
      print("No")
    else
      print("!")

  }

}

class Vector(val x: Int, val y: Int) {

  def + (that: Vector): Vector = new Vector(x + that.x, y + that.y)

  def unary_-():Vector = new Vector(-x, -y)

  def == (that: Any): Boolean = {
    print("Vector Equals")
    that match {
      case Vector(_x, _y) => x == _x && y == _y
      case _ => false
    }
  }

  override def toString: String = "Vector (" + str(x) + ", " + str(y) + ")"

}

object Vector {

  def unapply(arg: Vector): (Int, Int) = (arg.x, arg.y)
  def apply(x: Int, y: Int): Vector = new Vector(x, y)

}

object ZeroVector extends Vector(0, 0)