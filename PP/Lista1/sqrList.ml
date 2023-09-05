(*
    O(n)
    a' list -> a' list
*)
let rec sqrList xs =
    match xs with
    | [] -> []
    | h :: t -> (h*h) :: sqrList t;;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

print_list (sqrList [1;2;3;4;-5]);;
