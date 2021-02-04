class Test {

  def func(): String = {

    def inner(i: Int) =
      if (i == 0) 0
      else inner(i - 1) + inner(i - 2)

    "Return"

  }

}