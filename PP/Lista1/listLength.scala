object listLength {
    def main(args: Array[String]) : Unit = {
        def length[A](xs : List[A]) : Int =
            xs match {
                case List() => 0
                case _ :: t => 1 + length(t)
            }

        println(length(List(1,2,3,4,5)))
    }
}