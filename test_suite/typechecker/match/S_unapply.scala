class Foo {

  def foo(x: Vector): Int = x match {
    case ZeroVec => 0
    case Vec2(x, y) => x * y
    case Vec1(x) => x * x
  }

}

class Vector

class Vec1 (val x: Int) extends Vector

class Vec2 (val x: Int, val y: Int) extends Vector

object Vec1 {

  def unapply(that: Vec1): Int = that.x

}

object Vec2 {

  def unapply(arg: Vec2): (Int, Int)= (arg.x, arg.y)

}

object ZeroVec extends Vector