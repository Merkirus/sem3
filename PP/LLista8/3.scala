object Main {
	def main(args: Array[String]): Unit = {
		val z1 = new Complex(1,-2)
		val z2 = new Complex(4,3)
		val z3 = z1 + z2
		val z4 = z1 * z2
		val z5 = z1 - z2
		val z6 = z1 / z2
		val z7 = z1 == z2
		val z8 = (z1.conjugate(z2))
		println(z1.toString())
	}
}

final class Complex(private val re: Double = 0.0, private val im: Double = 0.0) {
	override def toString = if im < 0 then s"$re - ${im * (-1)}i" else s"$re + ${im}i"
	def +(other: Complex): Complex = Complex(re + other.re, im + other.im)
	def -(other: Complex): Complex = Complex(re - other.re, im - other.im)
	def *(other: Complex): Complex = Complex(re * other.re - im * other.im, re * other.im + im * other.re)
	def /(other: Complex): Complex = Complex((re * other.re + im * other.im)/(other.re * other.re + other.im * other.im), (im * other.re - re * other.im)/(other.re * other.re + other.im * other.im))
	def ==(other: Complex): Boolean = if (re == other.re && im == other.im) then true else false
	def conjugate(other: Complex): Complex = Complex(re, im * (-1))
}