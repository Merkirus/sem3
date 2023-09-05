object sqrList {
    def main(args: Array[String]) : Unit = {
        def sqrList(xs : List[Int]) : List[Int] =
            xs match {
                case List() => List()
                case h :: t => (h*h) :: sqrList(t)
            }
        println(sqrList(List(1,2,3,4,5)))
    }
}