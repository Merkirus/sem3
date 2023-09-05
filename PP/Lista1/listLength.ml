(*
    O(n)
    a' list -> int
*)
let rec length' xs =
    match xs with
    | [] -> 0
    | _ :: t -> 1 + length' t;;

print_int (length' [1;2;3;4;5]);;
