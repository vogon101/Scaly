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
      case 200 => "this"
    }

    val z = y match {
      case "Not this" => "Not this either"
      case p => "This: " + p
    }

//    var z = -1
//    var a = -1
//
//    print(a)
//    z = 100 match {
//      case a => 10 + a
//    }
//
//    print(a)

    // Should be "One abc"
//    val q = "abc" match { case x => ("def" match { case x => "One "}) + x }
//    print(q)

    print(str(x) + str(y) + str(z))

    print(str(x))

    ()

  }

}