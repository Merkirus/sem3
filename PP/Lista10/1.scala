// a) zasada podstawiania/zamienialnosci Liskov mowi nawet o funkcji
// s->t i s'->t', gdzie s<:s' i t'<:t, czyli funkcje przyjumujace argumenty (setter jak w zadaniu) sa kontrawariante
// b) tak, nadtyp [B >: T]
// c) nie, bo var tworzy i gettery i settery, czyli ma byc inwariatne
