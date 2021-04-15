object Main {

  def main() : Unit = {

    print(Vector(1,2))

    val v = new Vector(1,2)
    print(bar(v.foo))
    val z = bar
    print(z((x : Int) => x + 2))
    ()

  }

  def bar(f: Int => Int): Int = f(10)


}



class Vector (val x: Int, val y: Int) {

  def foo(z: Int): Int = z + x

}
object Vector {

  def apply(x: Int, y: Int): Vector = new Vector(x,y)

}