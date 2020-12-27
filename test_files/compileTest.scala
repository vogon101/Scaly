class Main {

//  def main(): String = {
//    if (false) {
//      1000
//      2000
//      3000
//      "Thing"
//    }
//    else{
//      50
//      "Not thing"
//    }
//  }

  def main(): Int = {

    val fg: FibGen = new FibGen
    print(new FibGen)

    print(fg)
    print(fg.x)
    print(fg.y)
    (new FibGen).fib(20)
//    val x: Int = 10
//    print(x)
//    (new FibGen).func(99)


  }


}
class FibGen {

  val x: Int = {
    print("Hello there")
    10
  }

  print("General")

  val y: Int = {
    print("Kenobi")
    100
  }

  def thing: Int = x

  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n < 3) 1
    else fib(n - 1) + fib (n - 2)
  }

  def func(n:Int): Int = {
    val x = 10
    print(x)
    print(n)
    x
  }

}


