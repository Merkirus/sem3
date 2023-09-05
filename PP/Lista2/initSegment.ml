(* O(n) *)
let rec initSegment (xs, xss) : bool =
    match (xs, xss) with
    | (_, []) -> false
    | ([], _) -> true
    | ((h_xs :: t_xs), (h_xss :: t_xss)) ->
        if h_xs = h_xss
        then initSegment (t_xs, t_xss)
        else false;;