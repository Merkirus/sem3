type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons (k, function () -> lfrom (k + 1));;

let ltake (n, lxs) =
	let rec inner_ltake (n, lxs, result) =
		match (n, lxs) with
		| (0, _) -> List.rev result
		| (_, LNil) -> List.rev result
		| (n, LCons(x, xf)) -> inner_ltake(n-1, xf(), x :: result)
	in inner_ltake (n, lxs, []);;

let rec print_list xs =
	match xs with
	| [] -> ()
	| e :: l -> print_int e; print_string " "; print_list l;;

print_list(ltake (2, lfrom 30));;
