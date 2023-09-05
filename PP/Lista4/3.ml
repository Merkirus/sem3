type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let inner_path_length bt =
	let rec traverse bt acc lvl =
		match bt with
		| Empty -> 0
		| Node(v, l ,r) ->	let a = traverse l (acc+lvl+1) (lvl+1)
							and b = traverse r (acc+lvl+1) (lvl+1)
							in a + b + lvl
	in traverse bt 0 0;;

let outer_path_length bt =
    let rec traverse bt acc lvl =
    	match bt with
        | Empty -> lvl
        | Node(v, l, r) -> 	let a = traverse l (acc+lvl+1) (lvl+1)
							and b = traverse r (acc+lvl+1) (lvl+1)
							in a + b
    in traverse bt 0 0;;

let tt = Node(1,
                Node(2,
                    Node(4,Empty,Empty),
                    Empty),
                Node(3,
                    Node(5,
                        Empty,
                        Node(6,Empty,Empty)
                        ),
                    Empty));;

let rec print_list xs =
	match xs with
	| [] -> ()
	| e :: l -> print_int e; print_string " "; print_list l;;

print_list((inner_path_length tt) :: []);;
print_list((outer_path_length tt) :: []);;