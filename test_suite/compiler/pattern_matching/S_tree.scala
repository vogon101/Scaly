/*
-13
None
 */
object Main {

  def main(): Unit = {
    //1 + (-2 * (3 + 4))
    val e = Add(Num(1), Mul(Neg(Num(2)), Add(Num(3), Num(4))))
    print(e.eval())
  }

}

class Expr {

  def eval(): Int = this match {
    case Add(l,r) => l.eval() + r.eval()
    case Neg(e) => -e.eval()
    case Mul(l, r) => l.eval() * r.eval()
    case Num(i) => i
  }

}

class Add(val lhs: Expr, val rhs: Expr) extends Expr
class Neg(val expr: Expr) extends Expr
class Mul(val lhs: Expr, val rhs: Expr) extends Expr
class Num(val value: Int) extends Expr

object Add {
  def apply(lhs: Expr, rhs: Expr): Add = new Add(lhs, rhs)
  def unapply(add:Add): (Expr, Expr) = (add.lhs, add.rhs)
}

object Neg {
  def apply(expr: Expr): Neg = new Neg(expr)
  def unapply(neg: Neg) : (Expr) = (neg.expr)
}

object Mul {
  def apply(lhs: Expr, rhs: Expr): Mul = new Mul(lhs, rhs)
  def unapply(mul: Mul): (Expr, Expr) = (mul.lhs, mul.rhs)
}

object Num {
  def apply(value: Int): Num = new Num(value)
  def unapply(num: Num): (Int) = (num.value)
}