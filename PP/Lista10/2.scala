// argument musi byc ogolniejszego typu niz A, podobnie jak 1) a) 
abstract class Sequence[+A] {
  def append[B >: A](x: Sequence[B]): Sequence[A]
}
