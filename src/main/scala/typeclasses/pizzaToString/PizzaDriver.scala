package typeclasses.pizzaToString

import typeclasses.pizzaToString.models._

object PizzaDriver extends App {
  import ToStringInstances._
  import ToStringSyntax._

  val pizza = Pizza(LargeCrustSize, ThinCrustType, Seq(Cheese, Pepperoni, Sausage))

  println(pizza.asString)
}
