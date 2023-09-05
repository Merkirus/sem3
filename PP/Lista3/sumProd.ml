let sum a b = a + b;;
let prod a b = a * b;;
let sumProd xs = List.fold_left (function acc -> function x -> (x + fst(acc), x * snd(acc))) (0,1) xs;;
let (x,y) = sumProd [1;2;3;4;5];;
print_int x;;
print_int y;;
(* List.fold_left : (a -> b -> a) -> a -> b list -> a, gdzie a bedzie krotka, wiec lambda
 przyjmuje krotke i inta, a zwraca krotke*)
