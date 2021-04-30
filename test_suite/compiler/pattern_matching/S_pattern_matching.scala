/*
X: 200
Y: this
Z: This: this
One abc
123
Pattern One, Two  3
None
 */

object Main {

  def main() : Unit = {


    val x = "Hello" match {
      case "Goodbye" => 100
      case "Hello" => 200
      case "Nothing" => 300
    }
    print("X: " + str(x))

    val y = x match {
      case 20 => "Not this"
      case 30 => "Not this"
      case 200 => "this"
    }

    print("Y: " + y)

    val z = y match {
      case "Not this" => "Not this either"
      case p => "This: " + p
    }

    print("Z: " + z)

    val q = "abc" match { case x => ("def" match { case x => "One "}) + x }
    print(q)

    val t = (1, (2, 3))

    val p = t match {
      case (x, (y,z)) => str(x) + str(y) + str(z)
    }

    val q = t match {
      case (0, x) => "Pattern zero " + str(x)
      case (1, (20, x)) => "Pattern One, Twenty " + str(x)
      case (1, (2, x)) => "Pattern One, Two  " + str(x)
    }

    print(p)

    print(q)

    ()

  }

}