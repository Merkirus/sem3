object palindrome {
    def main(args: Array[String]) : Unit = {
        def palindrome[A](xs : List[A]) : Boolean =
            def reverse[A](xss : List[A]) : List[A] =
                xss match {
                    case List() => List()
                    case h :: t => List.concat(reverse(t), List(h))
                }
            if reverse(xs) == xs then true else false
        println(palindrome(List('a','l','i')))
    }
}