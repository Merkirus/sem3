object patternMatching {
    def main(args : Array[String]) : Unit = {
        val xs = List(-2, -1, 0, 1 , 2);
        val List(_,_,x,_,_) = xs;
        println(x);

        val ys = List((1,2),(0,1));
        val List(_,(y,_)) = ys;
        println(y);
    }
}