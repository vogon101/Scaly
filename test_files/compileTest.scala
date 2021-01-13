object Main {

  val x: String = "Thing"

  def main(): Unit = {

    print(x)
    print(Main.x)
    print(StaticThing.foo("WOWW"))
    print(StaticThing.foo("WOWW"))
    print("Hello")

  }

}

object StaticThing {

  print("Constructor!")

  def foo(x: String): String = "!" + x + "!"

}