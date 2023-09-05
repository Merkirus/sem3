let rec accumulate f xs x =
	match xs with
	| [] -> x
	| h :: t -> f (accumulate f t x) h;;

let rec accumulate_tail f xs x =
	match xs with
	| [] -> x
	| h :: t -> accumulate_tail f t (f h x);;

let sum x y = x + y;;
let mult x y = x * y;;

print_int (accumulate_tail sum [3;6;8;9;13] 0);;
print_int (accumulate_tail sum [] 0);;
print_int (accumulate_tail sum [1] 0);;
print_int (accumulate_tail mult [2;4;4] 1);;
print_int (accumulate sum [] 0);;
print_int (accumulate sum [1] 0);;
print_int (accumulate mult [2;4;4] 1);;