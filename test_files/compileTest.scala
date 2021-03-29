object Main {

  def main() : Unit = {

//    val x = "Hello" match {
//      case x => "Goodbye " + x
//    }

    val x = "Hello" match {
      case "Goodbye" => 100
      case "Hello" => 200
      case "Nothing" => 300
    }

    val y = x match {
      case 20 => "Not this"
      case 30 => "Not this"
      case 100 => "this"
    }

    print(str(x) + str(y))

    ()

  }

}