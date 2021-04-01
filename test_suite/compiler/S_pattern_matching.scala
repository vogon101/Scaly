/*
200
this
This: this
None
 */

object Main {

  def main() : Unit = {

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


    print(x)
    print(y)
    print(z)

    ()

  }

}