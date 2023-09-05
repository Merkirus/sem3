 def przeksztalc(xs : List[(Float, Float)], fs : List[(Float, Float) => (Float, Float)]) : List[(Float, Float)] = {
	def inner(xs : List[(Float, Float)], result : List[(Float, Float)], f : (Float, Float) => (Float, Float)) : List[(Float, Float)] =
		xs match {
			case List() => result
			case h :: t => inner(t, result ::: List(f(h._1, h._2)), f)
		}
	def result(xs : List[(Float, Float)], fs : List[(Float, Float) => (Float, Float)]) : List[(Float, Float)] =	
		fs match {
			case List() => xs
			case h :: t => result(inner(xs, List(), h), t)
		}
	result(xs, fs)
}
val f1 = (x1 : Float, x2 : Float) => (x1 + 2, x2 - 2)
val f2 = (x1 : Float, x2 : Float) => (x1 * (-1), x2)
print(przeksztalc(List((1, 1), (2, 2)), List(f1, f2)))
