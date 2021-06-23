disturbance_of_memory_age(Vrednost, 0) :- Vrednost < 1, !.   
disturbance_of_memory_age(Vrednost, 0) :- Vrednost >= 1, Vrednost =< 4, !.
disturbance_of_memory_age(Vrednost, 0.3) :- Vrednost >= 5, Vrednost =< 14, !.
disturbance_of_memory_age(Vrednost, 0.3) :- Vrednost >= 15, Vrednost =< 29, !.
disturbance_of_memory_age(Vrednost, 0.4) :- Vrednost >= 30, Vrednost =< 44, !.
disturbance_of_memory_age(Vrednost, 1.1) :- Vrednost >= 45, Vrednost =< 59, !.
disturbance_of_memory_age(Vrednost, 1.9) :- Vrednost >= 60, Vrednost =< 74, !.
disturbance_of_memory_age(Vrednost, 3.6) :- Vrednost >= 75.

disturbance_of_memory_sex(Vrednost,1.0) :- Vrednost = 1, !.
disturbance_of_memory_sex(Vrednost,1.0) :- Vrednost = 0.

disturbance_of_memory_race(Vrednost,0.7) :- Vrednost = 0, !.
disturbance_of_memory_race(Vrednost,0.7) :- Vrednost = 1, !.
disturbance_of_memory_race(Vrednost,1.1) :- Vrednost = 2, !.
disturbance_of_memory_race(Vrednost,1.1) :- Vrednost = 3.




