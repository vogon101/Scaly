/*
0
1
1
2
3
5
8
13
 */

class Main {

  def main(): Int = {

    print((new FibGen).fib(0))
    print((new FibGen).fib(1))
    print((new FibGen).fib(2))
    print((new FibGen).fib(3))
    print((new FibGen).fib(4))
    print((new FibGen).fib(5))
    print((new FibGen).fib(6))
    (new FibGen).fib(7)


  }

}
class FibGen {

  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n < 3) 1
    else fib(n - 1) + fib (n - 2)
  }

}

