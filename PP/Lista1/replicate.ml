(*
    O(n)
    a' * int -> a' list
*)
let rec replicate (x,y) = if y <= 0 then [] else x :: replicate (x, y-1);;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_string e ; print_string " " ; print_list l;;

print_list (replicate ("la", 3));;
