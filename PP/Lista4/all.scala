sealed trait BT[A]
case class Empty[A]() extends BT[A]
case class Node[A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

sealed trait Graphs[A]
case class Graph[A](succ: A=>List[A]) extends Graphs[A]


object App4 {
  val tt = Node[Int](1,
    Node[Int](2,
      Node[Int](4,
        Empty[Int](),
        Empty[Int]()
      ),
      Empty[Int]()
    ),
    Node[Int](3,
      Node[Int](5,
        Empty[Int](),
        Node[Int](6,
          Empty[Int](),
          Empty[Int]()
        )
      ),
      Empty[Int]()
    )
  )
  val g = Graph((i: Int) => i match {
    case 0 => List(3)
    case 1 => List(0,2,4)
    case 2 => List(1)
    case 3 => Nil
    case 4 => List(0,2)
    case n => throw new Exception("Graph g: node „ + n" + " doesn't exist")
  })

  // Zad 3
  def breadthBT[T](bt: BT[T]): List[T] = {
    def breadthIn(acc: List[BT[T]], res: List[T]): List[T] = {
      acc match {
      	case Nil => res
      	case Empty() :: t => breadthIn(t, res)
      	case Node(v, l, r) :: t => breadthIn(t ::: List(l,r), v :: res)
      }
    }
    breadthIn(List(bt), List.empty[T]).reverse
  }

  // Zad 4
  def internalPath(bt: BT[Int]): Int = {
    def internal(bt: BT[Int], res: Int, lvl: Int): Int =
      bt match {
        case Empty() => 0
        case Node(v, l, r) => internal(l, res+lvl+1, lvl+1) + internal(r, res+lvl+1, lvl+1) + lvl
      }
    internal(bt, 0, 0)
  }

  def externalPath(bt: BT[Int]) = {
    def extern(bt: BT[Int], res: Int, lvl: Int): Int = {
      bt match {
        case Empty() => lvl
        case Node(v, l, r) => extern(l, res+lvl+1, lvl+1) + extern(r, res+lvl+1, lvl+1)
      }
    }
    extern(bt, 0, 0)
  }

  // Zad 5
  def depthSearch(gr: Graph[Int], st: Int):List[Int] = {
    def dfs(acc:List[Int], res:List[Int]):List[Int] = {
      acc match {
      	case Nil => res
      	case h :: t if res.contains(h) => dfs(t, res)
      	case h :: t => dfs((gr succ h) ::: t, h :: res)
      }
    }
    dfs(gr succ st, List(st)).reverse
  }

  def main(args: Array[String]): Unit = {
    println(tt)
    println(breadthBT(tt))

    println(internalPath(tt))
    println(externalPath(tt))

    println(g succ 0)
    println(depthSearch(g, 4))
  }
}
