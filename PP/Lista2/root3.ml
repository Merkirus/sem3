(* O(n), float -> float *)
let root3 a =
    let eps = 0.000000000000001 in
    let rec next_x (x, a) =
        if abs_float (x *. x *. x -. a) <= eps *. abs_float a
        then x else next_x (x +. ((a /. (x *. x)) -. x) /. 3.0, a)
    in match a with
        | a when a > 1.0 -> next_x (a /. 3.0, a)
        | _ -> next_x (a, a);;

print_float (root3 (9.0));;