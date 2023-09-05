(*
    O(n)
    a' list -> bool
*)
let palindrome xs =
    let rec reverse xss =
        match xss with
        | [] -> []
        | h :: t -> reverse t @ [h]
    in if reverse xs = xs then true else false;;

let int_of_bool b = if b then 1 else 0;;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_char e ; print_string " " ; print_list l;;

print_int (int_of_bool (palindrome ['a';'l';'a']));;
