object fib {
    def main(args: Array[String]) : Unit = {
        def fib(x : Int) : BigInt =
            x match {
                case 0 => 0
                case 1 => 1
                case n => if n > 0 then fib (n - 1) + fib (n - 2) else throw new Exception("Ujemna liczba");
            }
        println(fib(8))
    }
}