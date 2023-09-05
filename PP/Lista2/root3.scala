object root3 {
    def main(args : Array[String]) : Unit = {
        def root3(a : Double) : Double =
            val eps = 0.000000000000001;
            def next_x(x : Double, a : Double) : Double =
                if (x * x * x - a).abs <= eps * a.abs then x else
                    next_x (x + (a / (x * x) - x) / 3.0, a)
            a match {
                case a if a > 1 => next_x(a / 3.0, a)
                case _ => next_x(a, a)
            }
        println(root3(27.0));
    }
}