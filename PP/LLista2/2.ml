let grupuj xs =
    let rec accu xs acc =
        match xs with
        | [] -> []
        | h :: [] -> (h, acc) :: accu [] acc
        | h :: (nd :: t as tail)  when h = nd -> accu tail (acc+1)
        | h :: t -> (h, acc) :: accu t 1
    in accu xs 1;;

let x = ["1";"1";"1";"1";"2";"3";"3";"1";"1";"4";"4"];;
let y = ["1";"1";"2"];;
let z = [];;

let rec print_tuples =
  function
  | [] -> ()
  | (a, b) :: rest ->
    Printf.printf "%s, %i; " a b;
    print_tuples rest;;

print_tuples (grupuj x);;
print_string "\n";;
print_tuples (grupuj y);;
print_string "\n";;
print_tuples (grupuj z);;