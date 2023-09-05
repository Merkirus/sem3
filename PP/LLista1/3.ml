let przesun f ((x0 : float), (y0 : float)) = function x -> f (x -. x0) +. y0;;

let lin (x : float) = 2. *. x;;
let kwa (x : float) = 2. *. x *. x;;
let szesc (x : float) = 2. *. x *. x *. x +. 3. *. x *. x +. x;;

let przyklad = przesun (fun x -> x) (2., 3.) 1.;;
let lin_3_1 = przesun lin (3.0, 1.0);;
let kwa_1_2 = przesun kwa (1.0, 2.0);;
let szesc_2_5 = przesun szesc (2.0, 5.0);;

print_float przyklad;;
print_string "\n";;
(* 2 * (2 - 3) + 1 = -2 + 1 = -1 *)
print_float (lin_3_1 2.);;
print_string "\n";;
(* 2 * (2 - 1)^2 + 2 = 2 * 1 + 2 = 2 + 2 = 4 *)
print_float (kwa_1_2 2.);;
print_string "\n";;
(* 2 * (2 - 2)^3 + 3 * (2 - 2)^2 + (2 - 2) + 5 = 0 + 0 + 0 + 5 = 5 *)
print_float (szesc_2_5 2.);;