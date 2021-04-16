class Test {

  def test(): Int = {

    (1, 2) match {
      case (1,2) => 1
      case (1,2,3) => 2
    }

  }

}