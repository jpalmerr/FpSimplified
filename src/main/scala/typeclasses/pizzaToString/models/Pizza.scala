package typeclasses.pizzaToString.models

case class Pizza(
                   crustSize: CrustSize,
                   crustType: CrustType,
                   toppings: Seq[Topping]
                 )
