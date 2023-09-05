object Main {
	def main(args: Array[String]) = {
		val l1 = List(1,3,5,7,9,11);
		val l2 = List(2,4,6,8);
		val res = polacz(l1,l2);
		println(res);
	}

	def polacz(l1: List[Int], l2: List[Int]) : List[Int] = {
		def aux(l1: List[Int], l2: List[Int], res: List[Int]) : List[Int] = {
			(l1, l2) match {
				case (Nil, Nil) => res
				case (l1, Nil) => (l1.reverse) ::: res
				case (Nil, l2) => (l2.reverse) ::: res
				case (h1 :: t1, h2 :: t2) => aux(t1,t2,h2::h1::res)
			}
		}
		aux(l1,l2,List()).reverse
	}
}