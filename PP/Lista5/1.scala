def fib : LazyList[Int] = {
	def in_fib(p1 : Int, p2 : Int) : LazyList[Int] = {
		(p1 + p2) #:: in_fib(p2, p1+p2)
	}
	0 #:: 1 #:: in_fib(0,1)
}

def lfrom(n:Int):LazyList[Int] = {
    n #:: lfrom(n + 1)
}

sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]

def lrepeat[T](k : Int, lxs : LazyList[T]) : LazyList[T] = {
	def iterate(lxs : LazyList[T], acc : Int) : LazyList[T] = {
		lxs match {
			case LazyList() => LazyList()
			case h #:: t if (acc % (k+1)) == 0 => iterate(t, acc+1)
			case h #:: t => h #:: iterate(lxs, acc+1)
		}
	}
	iterate(lxs, 1)
}

def lTree(n : Int) : lBT[Int] = LNode(n, () => lTree(2*n), () => lTree(2*n+1))

def lBreadth[T](ltree : lBT[T]) : LazyList[T] = {
	def innerlBreadth(acc : List[lBT[T]]) : LazyList[T] = {
		acc match {
			case List() => LazyList()
			case LEmpty :: t => innerlBreadth(t)
			case LNode(v, l, r) :: t => v #:: innerlBreadth(t ::: List(l()) ::: List(r()))
		}
	}
	innerlBreadth(List(ltree))
}

def main(args: Array[String]): Unit = {
    println(lfrom(0).take(6).toList)

    println(lrepeat(3, lfrom(3)).take(10).toList)
    println(fib.take(15).toList)
    println(lBreadth(lTree(1)).take(20).toList)
}