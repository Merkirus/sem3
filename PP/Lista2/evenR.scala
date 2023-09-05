object fib {
    def main(args: Array[String]) : Unit = {
        def evenR(n : Int) : Boolean = if n == 0 then true else oddR(n - 1)
        def oddR(n : Int) : Boolean = if n == 0 then false else evenR(n - 1)
        println(evenR(200000))
    }
}

/* Głębokość stosu dla evenR(3) -> 4 (bez rekursji ogonowej)
(Na JVM rekursja ogonowa tylko dla wywołania samej siebie) */