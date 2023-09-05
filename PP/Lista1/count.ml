(*
    O(n) + O(n) = O(n) 
    a' * a' list -> int
*)
let rec count (x,y) =
    match (x,y) with
    | (_, []) -> 0
    | (x, h :: t) -> if h = x then 1 + count (x,t) else count (x,t);;

print_int (count ('a', ['a';'l';'a']));;
