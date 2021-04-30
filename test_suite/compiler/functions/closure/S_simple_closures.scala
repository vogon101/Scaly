/*
1
2
3
4
5
6
7
8
9
10
X: Hello .
Y: Mr .
==
Z: Poser.
>> String here
Hello Mr Poser
String here
101
None
 */
object Main {

  def main(): Unit = {

    val p: String = "String here"
    var barCounter: Int = 0

    def x(param1: String): String => String => Unit = {
      print("X: " + param1 + ".")
      def y(param2: String): String => Unit = {
        print("Y: " + param2 + ".")
        def z(param3: String): Unit = {
          print("Z: " + param3 + ".")
          print(">> " + p)
          print(param1 + param2 + param3)

        }

        z

      }

      y

    }

    def foo(z: Int): Int = {
      print(p)
      z + 1
    }

    def bar(): Unit = {
      barCounter = barCounter + 1
      print(barCounter)
    }

    while(barCounter < 10)
      bar()

    val curried = x("Hello ")("Mr ")
    print("==")
    curried("Poser")

    print(foo(100))

  }

}
