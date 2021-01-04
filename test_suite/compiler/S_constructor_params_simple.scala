/*
Making Dog
Doggo
10
woof
I am a dog called Doggo aged 10
I am a dog called Doggo aged 11
 */
class Main {

  def main(): Dog = {
    val dog = new Dog("Doggo", 10, "woof")
    print(dog)
    dog.getOlder()
    dog
  }

}

class Dog(val name: String, var age: Int, param: String) {

  print("Making Dog")
  print(name)
  print(age)
  print(param)

  override def toString: String = "I am a dog called " + name + " aged " + str(age)
  def getOlder(): Unit = age = age + 1

}
