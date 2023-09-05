let rec quicksort = function
    | [] -> []
    | [x] -> [x]
    | xs -> let small = List.filter (fun y -> y < List.hd xs) xs
            and large = List.filter (fun y -> y >= List.hd xs) xs (*Nieskonczone quicksortowanie large, jezeli List.hd nie jest najwiekszym elementem*)
            in quicksort small @ quicksort large;;

let rec quicksort' = function
    | [] -> []
    | x :: xs -> let small = List.filter (fun y -> y < x) xs
                and large  = List.filter (fun y -> y > x) xs (* Znikaja elementy rowne List.hd *)
                in quicksort' small @ (x :: quicksort' large);;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

(* print_list (quicksort [2;1;5;2;4;6]);; *)
print_list (quicksort' [2;1;5;2;4;6]);;
print_list (quicksort' [2;2;5]);;
