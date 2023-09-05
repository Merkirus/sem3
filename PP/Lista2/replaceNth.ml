(* O(n) *)
let rec repalceNth (xs, i, x) =
    match (xs, i, x) with
    | ([], _, _) -> []
    | ((h :: t), 0, x) -> x :: t
    | ((h :: t), i, x) -> h :: repalceNth (t, i - 1, x);;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_char e ; print_string " " ; print_list l;;

print_list (repalceNth (['o';'l';'a';'m';'a';'k';'o';'t';'a'], 1, 's'));;
