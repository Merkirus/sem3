def sumProd = (xs : List[Int]) => xs.foldLeft(0,1)((m, n) => (m._1 + n, m._2 * n));
