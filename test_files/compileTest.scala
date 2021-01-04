class Main {

  def main(): Dog = {
    val dog = new Dog("Doggo", 10, "other")
    print(dog)
    dog.getOlder()
    dog
  }

}

class Dog(val name: String, var age: Int, otherThing: String) {

  print("Dog")
  print(name)
  print(age)

  name = "Name"

  override def toString: String = "I am a dog called " + name + " aged " + str(age)

  def getOlder(): Unit = age = age + 1

}
