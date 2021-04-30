class Foo {

  def x(a: Object): String = a.toString

  def y(i: Int): Object = (this.x(this), 1)

  def z: Object = this

  def p(a: (Int, Int)): Boolean = a.equals(this)

}