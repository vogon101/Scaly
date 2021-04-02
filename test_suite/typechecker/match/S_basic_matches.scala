//TODO: Currently this will violate typesafety
//    Swapping to functions for case bodies will fix this

class Test {

  def foo(x: String): Unit = {

    val p: Int = x match {
      case "I am a string" => 100
      case "I am another string" => 200
      case z => isString(z)
    }

    print(123 + p + 123)

  }

  def isString(y: String): Int = 10

}