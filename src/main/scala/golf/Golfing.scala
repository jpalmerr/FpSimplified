package golf


object Golfing extends App {
  case class GolfState(strokes: List[Int])
  // take the old state, and an increment to that state
  def nextStroke(gs: GolfState,
                 distanceOfNextHit: Int): GolfState = { GolfState(distanceOfNextHit :: gs.strokes)
  }
  val state0 = GolfState(Nil)
  val state1 = nextStroke(state0, 20)
  val state2 = nextStroke(state1, 15)
  val state3 = nextStroke(state2, 0)
}
