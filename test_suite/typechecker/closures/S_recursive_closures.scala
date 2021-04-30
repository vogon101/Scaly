class Foo {

  def foo(x: Int): Int => Int = {
    def bar(y: Int) : Int = {
      if (y < 1) x + 1
      else foo(y - 1)(x-1)
    }
    bar
  }

  def main (): Unit = {
    print(foo(10)(10))

    def f(x: String): String = {

      def g(y: String): String = {

        def h(z: String): String  = f(z)

        h(x) + f(y)

      }

      g(x)

    }

    print("THing" + f("Things"))

  }

}