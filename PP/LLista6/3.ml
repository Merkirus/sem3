type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lpowiel lxs =
   let rec iterate lxs =
        let rec make_elem lxs n =
            match lxs with
            | LNil -> LNil
            | LCons(x, xf) when n = 0 -> iterate (xf()) 
            | LCons(x, xf) -> LCons(x, function () -> make_elem lxs (n-1))
        in
        match lxs with
        | LNil -> make_elem LNil 0
        | LCons(x, xf) -> make_elem lxs x
    in iterate lxs;;