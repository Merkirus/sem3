object replicate {
    def main(args: Array[String]) : Unit = {
        def replicate[A](x : A, y : Int) : List[A] =
            (x, y) match {
                case (_, 0) => List()
                case (x, y) => x :: replicate(x, y-1)
            }
        println(replicate("la", 3))
    }
}