object main {
	def main(args : Array[String]) =
		def zamien[A](xs : List[A], x : Int) =
			def inner_zamien[A](xs_left : List[A], xs_right : List[A], x : Int) : List[A] =
				 xs_right match {
				 	case List() => xs_right ::: xs_left
				 	case _ if x == 0 => xs_right ::: xs_left
				 	case h :: t => inner_zamien(xs_left ::: List(h), t, x - 1)
				}
			inner_zamien(List(), xs, x)
		print(zamien(List(1,7,5,6), 2))
		print("\n")
		print(zamien(List(1,1,2,1,2), 4))
		print("\n")
		print(zamien(List(), 2))
		print("\n")
		print(zamien(List(1), 2))
		print("\n")
		print(zamien(List(1,7,5,6), 5))
}