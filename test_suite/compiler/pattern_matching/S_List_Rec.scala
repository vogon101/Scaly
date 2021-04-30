/*
4
10
[ 1 [ 2 [ 3 [ 4 [] ] ] ] ]
None
 */
object Main {

  def sum(xs: List): Int = xs match {
    case Nil => 0
    case Cons(y, ys) => y + sum(ys)
  }

  def main() : Unit = {

    def length(xs: List): Int = {
      xs match {
        case Nil => 0
        case Cons(y, ys) => 1 + length(ys)
      }
    }

    val list: List = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))

    print(length(list))
    print(sum(list))
    print(list.toString)

  }

}

class List {

  def toString: String = this match {
    case Nil => "[]"
    case Cons(y, ys) => "[ " + str(y) + " " + ys.toString + " ]"
  }

}

class Cons(val head: Int, val tail: List) extends List

object Cons {

  def apply(hd: Int, tail: List): List = new Cons(hd, tail)

  def unapply(that: Cons): (Int, List) = (that.head, that.tail)

}

object Nil extends List
