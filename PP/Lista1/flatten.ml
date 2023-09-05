(* 
    O(n) -> [[],[]] -> [] @ [] @ [] etc
    O(m + k) -> [] @ [] -> []
    w flatten jest n konkatenacji
    flatten - O(n) + O(n * (m + k)) -> O(n * m) <- zakładam, że
    konkatenacja trwa m
    a' list list -> a' list
*)
let rec flatten xs =
    match xs with
    | [] -> []
    | h :: t -> h @ (flatten t);;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

print_list (flatten [[2;3;4];[1;6;9];[2;1]]);;
