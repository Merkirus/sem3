module type QUEUE_FUN =
sig
  type 'a t
  exception Empty of string
  val empty: unit -> 'a t
  val enqueue: 'a * 'a t -> 'a t
  val dequeue: 'a t -> 'a t
  val first: 'a t -> 'a
  val isEmpty: 'a t -> bool
end;;

module QueueList : QUEUE_FUN =
struct
  type 'a t = 'a list
  exception Empty of string
  let empty() = []
  let enqueue(a, t) = t @ [a]
  let dequeue t =
    match t with
    | [] -> []
    | head :: tail -> tail
  let first t =
    match t with
    | [] -> raise (Empty "first called on empty queue")
    | head :: tail -> head
  let isEmpty t = if t = [] then true else false
end;;

module QueueListPair : QUEUE_FUN =
struct
    type 'a t = 'a list * 'a list
    exception Empty of string
    let empty() = ([], [])
    let enqueue(e, t) =
      if fst(t) <> []
      then (fst(t), e :: snd(t))
      else
        let res = e :: snd(t) in
        (List.rev res, [])
    let dequeue t =
        match t with
        | ([], _) -> ([], [])
        | ([h1], l2) -> (List.rev l2, [])
        | (h1 :: t1, l2) -> (t1, l2)
    let first t =
      if fst(t) <> []
      then List.hd(fst(t))
      else raise (Empty "first called on empty queue")
    let isEmpty t =
      if fst(t) <> []
      then false
      else true
end;;


module type QUEUE_MUT =
sig
  type 'a t
  exception Empty of string
  exception Full of string
  val empty: int -> 'a t
  val enqueue: 'a * 'a t -> unit
  val dequeue: 'a t -> unit
  val first: 'a t -> 'a
  val isEmpty: 'a t -> bool
  val isFull: 'a t -> bool
end;;

module CircularQueue : QUEUE_MUT =
struct
  type 'a t = {mutable f : int; mutable r : int; size : int; mutable arr : 'a option array}
  exception Empty of string
  exception Full of string
  let empty s = {f = 0; r = 0; size = s + 1; arr = Array.make (s+1) None}
  let isFull t =
      t.r - t.f = t.size - 1 || t.r + 1 = t.f
  let isEmpty t =
    t.f = t.r
  let enqueue(a, t) =
    if isFull t
    then raise (Full "isFull")
    else t.arr.(t.r) <- Some a; t.r <- ((t.r + 1) mod (t.size + 1))
  let dequeue t =
    if isEmpty t
    then raise (Empty "isEmpty")
    else t.arr.(t.f) <- None; t.f <- ((t.f + 1) mod (t.size + 1))
  let first t =
    match t.arr.(t.f) with
    | Some e -> e
    | None -> raise (Empty "isEmpty")
end;;
