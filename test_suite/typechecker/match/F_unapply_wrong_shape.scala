class Foo {

  def foo(x: Vector): Int = x match {
    case ZeroVec => 0
    case Vec2(x, y, z) => x * y
  }

}

class Vector

class Vec2 (val x: Int, val y: Int) extends Vector
object Vec2 {

  def unapply(arg: Vec2): (Int, Int)= (arg.x, arg.y)

}

object ZeroVec extends Vector