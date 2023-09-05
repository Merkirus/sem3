def unique[A](xs : List[A]) : List[A] =
	def contains[A](x : A, xs : List[A]) : Boolean =
		xs match {
			case List() => false
			case h :: t if h == x => true
			case h :: t => contains(x, t)
		}
	def acc[A](x : A, xs : List[A], result : Int) : Int =
		xs match {
			case List() => result
			case h :: t if h == x => acc(x, t, result + 1)
			case h :: t => acc(x, t, result)
		}
	def single[A](xs : List[A], removed : List[A], result : List[A]) : List[A] =
		xs match {
			case List() => result
			case h :: t if contains(h, removed) => single(t, removed, result)
			case h :: t if acc(h, xs, 0) == 1 => single(t, removed, result ::: List(h))
			case h :: t => single(t, h :: removed, result)
		}
	single(xs, List(), List())