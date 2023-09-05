let f1 x y z = x y z;;
let f1 x y z = (((x) y) z);;
(* Czyli x jest funckja przyjmujaca dwa arg (a -> b -> c) *)
(* i zwracajaca jakas wartosc, gdzie lewa strona jest *)
(* "uncurry" tej funkcji, czyli (a -> b -> c) -> a -> b -> c, *)
(* gdzie a i b to arg, a c to wartosc zwracana *)
let f2 x y = function z -> x :: y;;
let f2 = function x -> function y -> function z -> x :: y;;
(* Widac ze y jest lista, a poniewaz dodajemy x do y, *)
(* to x musi byc tego samego typu jak y. Z jest po prostu *)
(* jakims argumentem, nie znamy jego typu, czyli *)
(* a -> a list -> b -> a list *)
let rec f x = f x;;
(* Podajemy arg x do funkcji f, gdzie funkcji ze wzgledu *)
(* na rekurencje nie jest w stanie rozponac zwracanego typu  *)
(* a -> b *)
