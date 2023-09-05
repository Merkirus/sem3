let obetnijkrance xs =
    let rec helper (xs, xs')  =
        match (xs, xs') with
        | (_, []) -> xs
        | (_, [_]) -> xs
        | (_, (h :: t)) -> helper ((xs @ [h]), t)
    in match xs with
        | [] -> []
        | _ :: t -> helper ([], t);;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

print_list (obetnijkrance []);;
print_string "\n";;
print_list (obetnijkrance [5;4;3;2]);;
print_string "\n";;
print_list (obetnijkrance [2]);;
print_string "\n";;
print_list (obetnijkrance [2;3]);;
print_string "\n";;
print_list (obetnijkrance [2;3;1]);;
print_string "\n";;
print_list (obetnijkrance [2;3;1;2;4;1;2]);;