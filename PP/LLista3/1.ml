let odwroc xs =
	let rec inner_odwroc xs xs' =
		match xs with
		| [] -> xs'
		| h :: t -> inner_odwroc t (h :: xs')
	in inner_odwroc xs [];;

let rec print_list xs =
    match xs with
    | [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

print_list (odwroc ([5;4;3;2]));;
print_string "\n";;
print_list (odwroc ([]));;
print_string "\n";;
print_list (odwroc ([1]));;
print_string "\n";;
print_list (odwroc ([5;2]));;
print_string "\n";;
print_list (odwroc ([1;2;3;4;5;6;7;8;9]));;