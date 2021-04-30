class Foo {

  def x(a: Any): Any = a == this
  def y(b: Int): Any = {
    print(x(b) == x(this))
    b
  }

}