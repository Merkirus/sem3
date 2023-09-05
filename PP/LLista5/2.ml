let insertionsort f xs =
	let rec insert f xs x =
		match xs with
		| [] -> [x] (* jezeli result jest pusty to "wkladamy" elem i zwracamy *)
		| h :: t when f x h -> x :: h :: t (* jezeli x spenila warunek to insertujemy go *)
		| h :: t -> h :: insert f t x (* jezeli x nie natrafil na swoje miejsce w liscie przechodzimy dalej *)
	(* funkcja przebiega xs i zwraca posortowany result przy uzyciu insert *)	
	in let rec inner f xs result =
		match xs with
		| [] -> result
		| h :: t -> inner f t (insert f result h)
	in inner f xs [];; (* ogolnie, przekladamy kazdy element z xs do result, wkladajac go
	na odpowiednie miejsce, sprawdzajac funkcja czy tam pasuje *)

(* punkty blizej zera daja true, czyli sortujemy rosnoca *)
(* nierownosc ostra poniewaz stabilnosc *)
let odleglosc x y =
	if ((fst(x) * fst(x) + snd(x) * snd(x)) < (fst(y) * fst(y) + snd(y) * snd(y)))
	then true
	else false;;

let rec print_list xs =
	match xs with
	| [] -> ()
	| e :: l -> print_int (fst(e)); print_int (snd(e)); print_string " "; print_list l;;

print_list( insertionsort odleglosc [(1,2);(2,1);(1,1);(0,0)]);;