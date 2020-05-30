package typeclasses.pizzaToString

import typeclasses.pizzaToString.models.Pizza

trait ToString[A] {
  def toString(a: A): String
}

object ToStringInstances {
  implicit val pizzaAsString = new ToString[Pizza] {
    def toString(p: Pizza): String = {
      s"""|Pizza(${p.crustSize}, ${p.crustType}),
          |      toppings = ${p.toppings}""".stripMargin
    }
  }
}

object ToStringSyntax {
  implicit class ToStringOps[A](value: A) {
    def asString(implicit toStringInstance: ToString[A]): String = {
      toStringInstance.toString(value)
    }
  }
}