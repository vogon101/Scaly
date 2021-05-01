/*
True
True
False
True
True
False
None
 */
object Main {

  def main(): Unit = {

    val foo = new Foo

    print(this.isInstanceOf[Main])
    print(this.isInstanceOf[Object])
    print(this.isInstanceOf[Foo])
    print(foo.isInstanceOf[Object])
    print(foo.isInstanceOf[Foo])
    print(foo.isInstanceOf[Main])

  }

}

class Foo

