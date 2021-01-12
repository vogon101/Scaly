class Test {

  def foo(): String = {
    val d = new Dog("Archie")
    d.name
  }

}

class Dog (name: String) {

  print(name)

}