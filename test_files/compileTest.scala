
class Main {

  def main(): Unit = {

    def hof(x: Int => String): String = {
      "---" + x(100) + " ---"
    }

    print(hof((x : Int) => str(x) + "O"))

  }

}