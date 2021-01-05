/*
Making animal James
Making animal Archie
Making Dog Archie aged 5
James
5
In Constructor
Making animal Puppy
Making Dog Puppy aged 1
Yap
Yap
None
 */
class Main {

  def main(): Unit = {
    val a = new Animal("James")
    val d = new Dog("Archie", 5)

    print(a.name)
    print(d.age)

    val thing = new Thing()
    print(thing.woof)

  }

}

class Animal (val name: String) {

  print("Making animal " + name)

}

class Dog (_n: String, val age: Int) extends Animal(_n) {

  print("Making Dog " + name + " aged " + str(age))

}

class Puppy (val woof: String) extends Dog("Puppy", 1)

class Thing extends Puppy({print("In Constructor"); "Yap"}) {

  print(woof)

}

