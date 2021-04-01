//TODO: Currently this will violate typesafety
//    Swapping to functions for case bodies will fix this

object Main {

  def main(): Unit = {
    print("X is a string")
    val x = "String"
    print(x)
    100 match {
      case x => ()
    }
    print("X is now an integer")
    print(x)
  }

}

