(* Operacje: Neg neguje Vect, Add dodaje Vec, Sub odejumuje Vec, Mul mnozy Scal i Vect, Prod mnozy Vect i Vect *)
type exp = Scal of float | Vect of float * float | Neg | Add | Sub | Mul | Prod;;

let eval xs =
    let rec inner_eval xs tstack =
        match xs with
        | [] ->
                if List.length tstack > 1
                then failwith "Zla ilosc argumentow w liscie"
                else
                    (match tstack with
                    | h :: t ->
                            (match h with
                            | Vect (x, y) -> Vect (x, y)
                            | _ -> failwith "Zwracana wartosc jest Scal")
                    | _ -> failwith "Pusta lista")
        | h :: t ->
                match h with
                | Scal x -> inner_eval t (Scal x :: tstack)
                | Vect (x, y) -> inner_eval t (Vect (x, y) :: tstack)
                | Neg ->
                        if List.length tstack < 1
                        then failwith "Za malo argumentow"
                        else
                            (match tstack with
                            | hs :: ts -> 
                                    (match hs with
                                    | Vect (x, y) -> inner_eval t (Vect (x *. -1., y *. -1.) :: ts)
                                    | _ -> failwith "Zly typ argumentu")
                            | _ -> failwith "Blad")
                | Add | Sub | Mul | Prod ->
                        if List.length tstack < 2
                        then failwith "Za malo argumentow"
                        else
                            match h, tstack with
                            | Add, hs1 :: hs2 :: ts ->
                                    (match hs1, hs2 with
                                    | Vect (x1, y1), Vect (x2, y2) -> inner_eval t (Vect (x1 +. x2, y1 +. y2) :: ts)
                                    | _ -> failwith "Zly typ argumentu")
                            | Sub, hs1 :: hs2 :: ts ->
                                    (match hs1, hs2 with
                                    | Vect (x1, y1), Vect (x2, y2) -> inner_eval t (Vect (x2 -. x1, y2 -. y1) :: ts)
                                    | _ -> failwith "Zly typ argumentu")
                            | Mul, hs1 :: hs2 :: ts ->
                                    (match hs1, hs2 with
                                    | Vect (x, y), Scal z -> inner_eval t (Vect (x *. z, y *. z) :: ts)
                                    | _ -> failwith "Zly typ argumentu") 
                            | Prod, hs1 :: hs2 :: ts ->
                                    (match hs1, hs2 with
                                    | Vect (x1, y1), Vect (x2, y2) -> inner_eval t (Vect (x1 *. x2, y1 *. y2) :: ts)
                                    | _ -> failwith "Zly typ argumentu")
                            | _, _ -> failwith "Blad"
    in inner_eval xs [];;

let ll1 = [Scal 5.; Vect (1.,1.); Mul; Vect (5.,5.); Prod; Vect (25.,25.); Sub; Vect (1.,1.); Add; Neg; Vect (1.,1.); Add];;
let ll2 = [Scal 2.; Vect (5.,5.); Vect (2.,2.); Prod; Mul; Neg; Neg];;
let ll3 = [Scal 5.];;
let ll4 = [];;
let ll5 = [Vect (5.,5.); Vect (5.,5.)];;
let vector = (eval ll2);;
let print_vect vect =
    match vect with
    | Vect (x, y) -> print_float x; print_float y
    | _ -> failwith "Zly argument";;
print_vect vector;;