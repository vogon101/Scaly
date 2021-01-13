/*
0
1
1
2
3
5
8
13
21
34
55
None
 */
object Main {

  def main(): Unit = {

    val fg: FibGen = new FibGen
    var i = 0
    while (i <= 10) {
      print(fg.fib(i))
      i = i + 1
    }


  }

}

class FibGen {

  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n < 3) 1
    else fib(n - 1) + fib (n - 2)
  }

}