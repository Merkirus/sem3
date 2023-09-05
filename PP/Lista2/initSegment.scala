object initSegment {
  def main(args : Array[String]) = {
    def initSegment[A](xs : List[A], xss : List[A]) : Boolean =
      (xs, xss) match {
        case (_, List()) => false
        case (List(), _) => true
        case ((h_xs :: t_xs), (h_xss :: t_xss)) =>
          if h_xs == h_xss then initSegment(t_xs, t_xss) else false;
      }
  }
}
