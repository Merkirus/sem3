object main {
  def main(args : Array[String]) : Unit = {
    def insertionsort[A](f : (A, A) => Boolean, xs : List[A]) : List[A] = {
      def insert[A](f : (A, A) => Boolean, xs : List[A], x : A) : List[A] =
        xs match {
          case List() => List(x)
          case h :: t if f(x, h) => x :: h :: t
          case h :: t => h :: insert(f, t, x)
        }
      def inner[A](f : (A, A) => Boolean, xs : List[A], result : List[A]) : List[A] =
        xs match {
          case List() => result
          case h :: t => inner(f, t, (insert(f, result, h)))
        }
      inner(f, xs, List())

    def mergesort[A](f : (A, A) => Boolean, xs : List[A]) : List[A] =
      def halve(xs : List[A]) : (List[A], List[A]) =
        def inner_halve(left : List[A], right : List[A], acc : Int) : (List[A], List[A]) =
          (right, acc) match {
            case (_, 0) => (left.reverse, right)
            case (h :: t, _) => inner_halve(h :: left, t, acc - 1)
            case _ => (List(), List())
          }
        inner_halve(List(), xs, xs.length/2)
      def merge(left : List[A], right : List[A]) : List[A] =
        (left, right) match {
          case (List(), _) => right
          case (_, List()) => left
          case (hl :: tl, hr :: tr) =>
            if f(hl, hr) then hl :: merge(tl, right) else hr :: merge(left, tr)
        }
      xs match {
        case List() => List()
        case List(x) => List(x)
        case _ => val (left, right) = halve(xs)
                  merge (mergesort(f, left), mergesort(f, right))
      }
    }
  }
}
