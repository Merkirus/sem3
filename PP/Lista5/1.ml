type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lrepeat k lxs =
   let rec iterate lxs acc =
        match lxs with
        | LNil -> LNil
        | LCons(x, xf) when (acc mod (k+1)) = 0  -> iterate (xf()) (acc+1)
        | LCons(x, xf) -> LCons(x, function () -> iterate lxs (acc+1))
	in iterate lxs 1;;

let rec lfrom k = LCons (k, function () -> lfrom (k+1));;
let rec ltake = function
| (0, _) -> []
| (_, LNil) -> []
| (n, LCons(x,xf)) -> x::ltake(n-1, xf());;

let rec print_list xs =
	match xs with
	| [] -> ()
	| e :: l -> print_int e; print_string " "; print_list l;;

print_list(ltake(15, (lrepeat 3 (lfrom 1))));;
print_string "\n";;

let fib =
	let rec inner_fib prev_1 prev_2 =
		LCons(prev_1 + prev_2, function () -> inner_fib prev_2 (prev_1+prev_2))
	in LCons(0, function () -> LCons(1, function () -> inner_fib 0 1));;

print_list(ltake(15,fib));;

print_string "\n";;

type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT)  * (unit -> 'a lBT);;

let rec lTree n = LNode(n, (function () -> lTree (2*n)), (function () -> lTree (2*n+1)));;

let lBreadth lbt =
	let rec inner_lBreadth acc =
		match acc with
		| [] -> LNil
		| LEmpty :: t -> inner_lBreadth t
		| LNode(v, l, r) :: t -> LCons(v, function () -> inner_lBreadth (t @ [l(); r()]))
	in inner_lBreadth [lbt];;

print_list(ltake(20, lBreadth (lTree 1)));;