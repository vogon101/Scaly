class Test {

  def foo(y: String): String = {
    val z: String = y match {
      case "String" => 100
    }

    y + z

  }

}