class Animal(val name: String)

class Dog(_n: String) extends Animal(_n) {

  print(_n)
  print(name)

}

class Puppy(val unit: Unit) extends Dog("Puppy")

class Thing extends Puppy(print("Name")) {

  print(unit)

}

