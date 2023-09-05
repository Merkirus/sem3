(* O(2^n), bo wysokosc drzewa n
(każda kolejna warstwa ma 2*poprzednia)
int -> int *)
let rec fib n =
    match n with
    | 0 -> 0
    | 1 -> 1
    | n -> if n > 0 then fib (n - 1) + fib (n - 2) else failwith "Ujemna liczba";;

print_int (fib 12);;