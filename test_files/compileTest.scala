class Main {

  def foo(x: Int): String = {

    def bar(y: String, z: Int): (String, Int) = {

      if (z < 1) (y + "!", z)
      else (foo(z - 1) + "?" + foo(z - 2), z - 1)

    }

    val res = bar("", x)
    "(" + res._1 + res._2 + ")"

  }

  def main(): Unit = {

    print(foo(1))

    print(foo(2))

    print(foo(3))

  }

}

