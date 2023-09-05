(* O(n), int -> int *)
let fibTail n =
    let rec aux (n, (x, y)) = if n = 0 then x else aux (n-1, (y, x+y))
        in if n >= 0 then aux (n, (0, 1)) else failwith "Ujemna liczba";;

print_int (fibTail 1);;
