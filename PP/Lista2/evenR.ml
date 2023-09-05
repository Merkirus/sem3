(* O(n), int -> int *)
let rec evenR n = if n = 0 then true else oddR (n-1)
and oddR n = if n = 0 then false else evenR (n-1);;

let bool_of_int n = if n = true then 1 else 0;;

print_int(bool_of_int (evenR 200000000));;

(* Głębokość stosu dla evenR(3) -> 1,
   funkcje się zamieniają ze względu na rekursję ogonową *)