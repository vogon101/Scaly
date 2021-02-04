class Foo {

  val x = "This is a String"

  val y = 34

  def func(i : Int): String = {

    val z = y + i

    def inner(x : String) = x == "Test"

    //TODO: In Scala if this were annotated this would work - eg defs within a block do not
    //  need to be in textual order
    //  def mutual1(x : String) = mutual2(x)
    //  def mutual2(x : String) = mutual1(x)

    func(y + z)

    if (inner(x)) print("This is a thing")
    else print("This is not a thing")

    x
  }

}