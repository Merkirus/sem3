object fibTail {
    def main(args: Array[String]) : Unit = {
        def fibTail(x : Int) : BigInt =
            def aux(x : Int, a : Int, b : Int) : Int =
                if x == 0 then a else aux (x-1, b, a+b)
            if x > 0
                then return aux (x, 0, 1)
                else throw new Exception("Ujemna liczba");
        println(fibTail(42))
    }
}