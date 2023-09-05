class UnderflowException(msg: String) extends Exception(msg)

class MyQueue[+T] private(private val queue: (List[T], List[T])) {
  def enqueue[S >: T](element: S): MyQueue[S] = {	
    val (beginningOfQueue, endOfQueue) = queue
    normalize(beginningOfQueue, element :: endOfQueue)
  }

  private def normalize[S >: T](list1: List[S], list2: List[S]) =
    (list1, list2) match {
      case (Nil, endOfQueue) => new MyQueue[S]((endOfQueue.reverse, Nil))
      case normalQueue => new MyQueue[S](normalQueue)
    }

  def dequeue: MyQueue[T] =
    queue match {
      case (_ :: tail, endOfQueue) => normalize(tail, endOfQueue)
      case _ => MyQueue.empty
    }
    

  def first: T =
    queue._1 match {
      case (head :: _) => head
      case _ => throw new UnderflowException("first")
    }

  def isEmpty: Boolean =
    if queue._1 == Nil then true else false

//only for tests
  override def equals(obj: Any): Boolean =
    obj match {
      case obj: MyQueue[_] => queue._1 ++ queue._2.reverse == obj.queue._1 ++ obj.queue._2.reverse
      case _ => false
    }
}

object MyQueue {
  def apply[T](xs: T*) = new MyQueue[T](xs.toList, Nil)

  def empty[T] = new MyQueue[T](Nil, Nil)
}
