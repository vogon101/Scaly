object Fib {

  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n < 3) 1
    else fib(n - 1) + fib (n - 2)
  }

}

class Main {

  def main(): Int = Fib.fib(10)

}


//class Main {
//
//
//  def main(): Unit = {
//
//    val fg: FibGen = new FibGen
//////    print(new FibGen)
//////
//////    print(fg)
//////    print(fg.x)
//////    print(fg.y)
////
////    var x: Int = 100
////    print(x)
////    x = 90
////    print(x)
//
//    var i: Int = 0
//    while (i < 10) {
//      print(fg.fib(i))
//      i = i + 1
//    }
//
//    val x: B = (new A)
//
//    print(fg.fib(10))
//    fg.foo()
//    fg.returnsNothing()
//
//
////    (new FibGen).fib(20)
////    val x: Int = 10
////    print(x)
////    (new FibGen).func(99)
//
//
//  }
//
//
//
//}
////class A {
////
////
////  val apply: Int = 100
////
////}
//
//class A {
//  def foo(): Int = 100
//  def apply: B = new B
//
//}
//
//class B {
//
//  def apply(): Unit = print("Hello")
//
//}
//
//
//
//
//class FibGen extends A {
//
////  val x: Int = {
////    print("Hello there")
////    10
////  }
////
////  print("General")
////
////  val y: Int = {
////    print("Kenobi")
////    100
////  }
////
////  def thing: Int = x
//
//  def fib(n: Int): Int = {
//    if (n == 0) 0
//    else if (n < 3) 1
//    else fib(n - 1) + fib (n - 2)
//  }
//
//  def returnsNothing(): Unit = {}
//
////  def func(n:Int): Int = {
////    val x = 10
////    print(x)
////    print(n)
////    x
////  }
//
//}
//
//
