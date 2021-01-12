/*
[Printer] Warning | This is a test
[Printer] Warning | This is another test
 */
class Main {

  def main(): Unit = {

    val printer: String => Unit = createAPrinter("Warning | ")

    printer("This is a test")
    printer("This is another test")

  }

  def createAPrinter(level: String): String => Unit =
    (new Printer("[Printer]")).getPrinter(level)

}

class Printer(val prefix: String) {

  def getPrinter(level: String): String => Unit = {

    def _print(s: String): Unit =
      print(prefix + " " + level + " " + s)

    _print

  }

}