package typeclasses.cats

object Driver extends App {

  import cats.Show           //the type class
  import cats.syntax.show._  //the interface syntax

  implicit val pizzaShow = Show.show[Pizza] { p =>
    s"""|Pizza(${p.crustSize}, ${p.crustType}),
        |toppings = ${p.toppings}\"\"\".stripMargin""".stripMargin
  }

  val pizza = Pizza(
    LargeCrustSize,
    ThinCrustType,
    Seq(Cheese, Pepperoni, Sausage)
  )

  println(pizza.show)

  // more show

  import cats.instances.int._ // now we get show on int instances for free
  import cats.instances.list._

  println(123.show)
  println(List(1, 2, 3).show)

}
