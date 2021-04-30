class Main {

  def foo(): Unit = {

    def z(v: Vector): Boolean = true

    val v1 = new Vector(100, 200)

    print(v1 + ZeroVector)
    print((-ZeroVector) + v1)
    if (z(-v1)) {
      print("Thing")
    }

  }

}

class Vector(val x: Int, val y: Int) {

  def + (that: Vector): Vector = new Vector(x + that.x, y + that.y)

  def unary_-():Vector = new Vector(-x, -y)

}

object ZeroVector extends Vector(0, 0)