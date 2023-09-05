type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let breadthBT bt =
    let rec inner_breadthBT acc result =
        match acc with
        | [] -> result
        | Empty :: t -> inner_breadthBT t result
        | Node(v, l, r) :: t -> inner_breadthBT (t @ [l; r]) (v :: result)
    in List.rev (inner_breadthBT [bt] []);;

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

print_list(breadthBT tt);;
