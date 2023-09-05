let duplicate xs mult =
	let rec aux xs mult result =
		match (xs, mult) with
		| ([], _) -> result
		| (_, []) -> result
		| (h_x :: t_x, 0 :: t_m) -> aux t_x t_m result
		| (h_x :: t_x, h_m :: t_m) -> aux xs ((h_m - 1) :: t_m) (h_x :: result)
	in List.rev(aux xs mult []);;

let rec print_list xs =
	match xs with
	| [] -> ()
	| e :: l -> print_int e; print_string " "; print_list l;;

print_list(duplicate [1;2;3] [0;3;1;4]);;