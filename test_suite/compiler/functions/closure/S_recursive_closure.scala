/*
((!0)?(!-1)0)
(((!0)?(!-1)0)?(!0)1)
((((!0)?(!-1)0)?(!0)1)?((!0)?(!-1)0)2)
2
6
16
None
 */
object Main {

  def foo(x: Int): String = {

    def bar(y: String, z: Int): (String, Int) = {

      if (z < 1) (y + "!", z)
      else (foo(z - 1) + "?" + foo(z - 2), z - 1)

    }

    val res = bar("", x)
    "(" + res._1 + str(res._2) + ")"

  }

  def main(): Unit = {

    def gamma(x: Int): Int = {

      def delta(y: Int): Int =
        if (y < 1) x
        else gamma(y - 1) + delta(y - 1)

      delta(x) + delta(x - 1)

    }

    print(foo(1))
    print(foo(2))
    print(foo(3))

    print(gamma(1))
    print(gamma(2))
    print(gamma(3))

  }

}

