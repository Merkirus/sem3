def polacz(xs : List[String]) : List[Int] =
    xs match {
        case List() => List()
        case (h :: t) => h.length() :: polacz(t)
    }

println(polacz(List("To", "jest", "napis")));
println(polacz(List("Trzy", "cztery", "piec")));
println(polacz(List("OCaml", "Scala", "Java")));
println(polacz(List("Prosty", "test", "dziala")));
println(polacz(List("Och", "", "i")));
