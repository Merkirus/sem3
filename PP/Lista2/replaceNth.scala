object replaceNth {
  def main(args : Array[String]) = {
    def replaceNth[A](xs : List[A], i : Int, x : A) : List[A] =
      xs match {
        case List() => List()
        case h :: t if i == 0 => x :: replaceNth(t, i - 1, x)
        case h :: t => h :: replaceNth(t, i - 1, x)
      }
  }
}
