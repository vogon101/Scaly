/*
0
10
None
 */
object Main {

  def main(): Unit = {
    val f:(() => (), () => Int) = (new Container).getFunctions()

    print(f._2())

    (new Container).doTenTimes(f._1)

    print(f._2())

  }

}

class Container {

  def getFunctions():(() => (), () => Int) = {

    var counter: Int = 0

    (() => counter = counter + 1, () => counter)

  }

  def doTenTimes(f: () => ()): Unit = {
    var i = 0
    while(i < 10) {
      f()
      i = i + 1
    }
  }

}

