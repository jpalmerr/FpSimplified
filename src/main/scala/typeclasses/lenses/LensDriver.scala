package typeclasses.lenses

object LensDriver extends App {

  val user = User(
    id = 1,
    name = Name(
      firstName = "Al",
      lastName = "Alexander"
    ),
    billingInfo = BillingInfo(
      creditCards = Seq(
        CreditCard(
          name = Name("John", "Doe"),
          number = "1111111111111111",
          month = 3,
          year = 2020,
          cvv = ""
        )
      )
    ),
    phone = "907-555-1212",
    email = "al@al.com"
  )

  import com.softwaremill.quicklens._

  // To show how a lens works, assume that you need to change both the User.phone and User.email fields

  // one at a time
  val u1 = user.modify(_.phone).setTo("111-222-3333")
  val u2 = u1.modify(_.email).setTo("james@james.com")

  println(u2)

  // multiple at a time

  val u3 = user.modify(_.phone).setTo("111-222-333")
    .modify(_.email).setTo("james@example.com")
    .modify(_.name.firstName).setTo("James")

  println(u3)

  import cats.Show
  import cats.syntax.show._

  implicit val userShow = Show.show[User] { u =>
    s"""User: ${u.name.firstName} ${u.name.lastName}, Email: ${u.email}"""
  }

  println(u3.show)

}
