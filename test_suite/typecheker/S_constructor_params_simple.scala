class Main {

  def main(): Dog = {
    val dog = new Dog("Doggo", 10, "woof")
    print(dog)
    print(dog.name)
    dog.getOlder()
    dog
  }

}

class Dog(val name: String, var age: Int, param: String) {

  print("Dog")
  print(name)
  print(age)
  print(param)

  override def toString: String = "I am a dog called " + name + " aged " + str(age)
  def getOlder(): Unit = age = age + 1

}
