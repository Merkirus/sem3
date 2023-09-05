let insertionsort f xs =
    let rec insert f xs x =
        match xs with
        | [] -> [x]
        | h :: t when f x h -> x :: h :: t
        | h :: t -> h :: insert f t x
    in let rec inner f xs result =
        match xs with
        | [] -> result
        | h :: t -> inner f t (insert f result h)
    in inner f xs [];;

let rec mergesort f xs =
    let halve xs =
        let rec inner_halve left right acc =
            match right, acc with
            | _, 0 -> (List.rev left, right)
            | h :: t, _ -> inner_halve (h :: left) t (acc - 1)
            | _, _ -> assert false
        in inner_halve [] xs ((List.length xs)/2)
    in let rec merge left right =
        match left, right with
        | [], right -> right
        | left, [] -> left
        | (hl :: tl), (hr :: tr) -> if (f hl hr)
                                    then hl :: merge tl right
                                    else hr :: merge left tr
    in match xs with
        | [] -> []
        | [x] -> [x]
        | _ -> let (left, right) = halve xs
                in merge (mergesort f left) (mergesort f right);;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

print_list (insertionsort (>) [2;1;4;3;7]);;
print_string "\n";;
print_list (mergesort (>) [2;1;4;3;7]);;
