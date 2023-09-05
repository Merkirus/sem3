object main {
  def main(args : Array[String]) = {
    def grupuj[A](xs : List[A]) : List[List[A]] = 
      def concat[A](xs : List[A], temp : List[A], result : List[List[A]]) : List[List[A]] =
        xs match {
          case List() => result
          case h :: List() => concat(List(), List(), result ::: List(h :: temp))
          case h :: t if h == t.head => concat(t, h :: temp, result)
          case h :: t => concat(t, List(), result ::: List(h :: temp))
        }
      concat(xs, List(), List())
    print(grupuj(List(1,1,1,1,2,3,3,1,1,4,4)))
  }
}
