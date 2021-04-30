class Foo {

  def h(f: String => Nothing): Int = f("Hello")
  def g(f: Null => String): String = f(null)

}