type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let rec lustruj tree =
	match tree with
	| Empty -> Empty
	| Node(a, t1, t2) -> Node(a, lustruj t2, lustruj t1);;

let tt = Node(1,
		Node(2,
			Node(6,Empty,Empty),
			Node(5,Empty,Empty)
		),
		Node(3,
			Node(4, Empty, Empty),
			Node(7,Empty,Empty)
		)
	);;

let rec preorder = function
	Node(v,l,r) -> v :: (preorder l) @ (preorder r)
	| Empty -> [];;

let rec print_list xs =
match xs with
| [] -> ()
| e :: l -> print_int e; print_string " "; print_list l;;

let tt2 = lustruj tt;;
print_list (preorder tt);;
print_string "\n";;
print_list (preorder tt2);;