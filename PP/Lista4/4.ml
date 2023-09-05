type 'a graph = Graph of ('a -> 'a list);;

let g = Graph
(function
0 -> [3]
| 1 -> [0;2;4]
| 2 -> [1]
| 3 -> []
| 4 -> [0;2]
| n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist")
);;

let depthSearch (Graph g) n =
	let rec inner_depthSearch acc result =
		match acc with
		| [] -> result
		| h :: t when List.mem h result -> inner_depthSearch t result
		| h :: t -> inner_depthSearch (g(h) @ t) (h :: result)
	in List.rev (inner_depthSearch (g(n)) [n]);;

let rec print_list xs =
	match xs with
	| [] -> ()
	| e :: l -> print_int e; print_string " "; print_list l;;

print_list(depthSearch g 4);;