sealed trait Debug {
	def debugName(): Unit = {
		println(s"Klasa: ${getClass().getSimpleName()}")
	}
}

class Point(xv: Int, yv: Int) extends Debug {

    var x: Int = xv

    var y: Int = yv

    var a: String = "test"

}

object Main {
	def main(args: Array[String]): Unit = {
		var p = new Point(3,4);
		p.debugName();
	}
}