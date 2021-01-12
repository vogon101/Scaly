class Test {

  def outer(): Unit = {
    val x: Int = 1
    def inner(): Unit = {
      x = 10
    }
    print(x)

  }

}