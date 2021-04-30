class Foo {

  val x: String = if (true) "Thing" else "Other Thing"

  def foo(y: String):Int = if (y == "String") 100 else 0

  def bar(x: String): Unit = if (x == "String") print("Hello")

}