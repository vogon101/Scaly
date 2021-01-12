/*
Making printer with [Printer]
[Printer] Warning | This is a test
[Printer] Warning | This is another test
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
      print(prefix + " " + level + " | " + s)

    _print

  }

}