object flatten {
    def main(args: Array[String]) : Unit = {
        def flatten[A](xs : List[List[A]]) : List[A] =
            xs match {
                case List() => List()
                case h :: t => List.concat(h, (flatten(t)))
            }
        println(flatten(List(List(1,2,3), List(1,2,3))))
    }
}