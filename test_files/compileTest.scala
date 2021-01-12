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
X: Hello
Y: Mr
==
Z: Poser
>> String here
Hello Mr Poser
String here
101
None
 */
class Main {

  def main(): Unit = {

    val printer: String => Unit = (new Container).createAPrinter("Warning")

    printer("This is a test")
    printer("This is another test")

  }

}

class Container {
  def createAPrinter(level: String): String => Unit =
    (new Printer("[Printer]")).getPrinter(level)

}

class Printer(val prefix: String) {

  def getPrinter(level: String): String => Unit = {

    print("Making printer with " + prefix)

    def _print(s: String): Unit =
      print(prefix + " " + level + " " + s)

    _print

  }

}