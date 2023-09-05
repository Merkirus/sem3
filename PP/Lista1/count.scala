object count {
    def main(args: Array[String]) : Unit = {
        def count[A](x : A, xs : List[A]) : Int =
            (x, xs) match {
                case (_, List()) => 0
                case (x, (h :: t)) => if h == x then 1 + count(x, t) else count(x, t)
            }

        println(count[Char]('a', List('a', 'l', 'a')))
    }
}