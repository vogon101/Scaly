/*
Hello there
General
Kenobi
10
 */
object Main {

  def main(): Int = {

    (new Test).x


  }

}

class Test {

  val x: Int = {
    print("Hello there")
    10
  }

  print("General")

  val y: Int = {
    print("Kenobi")
    100
  }

}
