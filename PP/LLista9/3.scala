class Debug {}

object Debug {
	def fields(obj: Object): Unit = {
		obj.getClass().getDeclaredFields().foreach(field => {
			field.setAccessible(true)
			println(s"Pole: ${field.getName()} => ${field.getType().getName()}, ${field.get(obj)}")
		})
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
		Debug.fields(p)
	}
}