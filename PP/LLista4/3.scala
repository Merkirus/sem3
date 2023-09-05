def calkuj(f : Double => Double)(a : Double, b : Double)(n : Int) : Double =
	def sigma(f : Double => Double)(n : Int)(h : Double) : Double =
		def suma(i : Int, s : Double) : Double =
			if i == n then s else suma(i + 1, s + (f(a + i * h) + f(a + (i + 1) * h)))
		suma(0, 0)
	if n == 0
		then throw new Exception("Zły podział")
		else
			var h = (b - a) / n
			((sigma(f)(n)(h)) * h / 2)

print(calkuj((x : Double) => x * x - 1)(-1.0,1.0)(1000))
print("\n")
print(calkuj(((x : Double) => 2*x) compose ((x : Double) => x * x - 1))(-1.0,1.0)(2))