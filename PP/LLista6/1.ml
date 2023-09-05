type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec filter lxxs n =
	let rec lLength lxs acc =
		match lxs with
		| LNil -> acc
		| LCons(x,xf) -> lLength (xf()) (acc+1)
	in
	match lxxs with
	| LNil -> LNil
	| LCons(x,xf)  ->
			if (lLength x 0) >= n
			then LCons(x, function() -> filter (xf()) n)
			else filter (xf()) n;;