let curry3 f a b c  = f (a,b,c);;
let curry3_nosugar = function f -> function a -> function b -> function c -> f(a,b,c);;
let uncurry3 f (a,b,c) = f a b c;;
let uncurry3_nosugar = function f -> function (a,b,c) -> f a b c;;
