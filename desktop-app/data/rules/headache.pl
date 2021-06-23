headache_age(Vrednost, 0) :- Vrednost < 1, !.   
headache_age(Vrednost, 0.2) :- Vrednost >= 1, Vrednost =< 4, !.
headache_age(Vrednost, 1.4) :- Vrednost >= 5, Vrednost =< 14, !.
headache_age(Vrednost, 1.4) :- Vrednost >= 15, Vrednost =< 29, !.
headache_age(Vrednost, 1.4) :- Vrednost >= 30, Vrednost =< 44, !.
headache_age(Vrednost, 1.0) :- Vrednost >= 45, Vrednost =< 59, !.
headache_age(Vrednost, 0.6) :- Vrednost >= 60, Vrednost =< 74, !.
headache_age(Vrednost, 0.5) :- Vrednost >= 75.

headache_sex(Vrednost,0.8) :- Vrednost = 1, !.
headache_sex(Vrednost,1.1) :- Vrednost = 0.

headache_race(Vrednost,1.1) :- Vrednost = 0, !.
headache_race(Vrednost,1.0) :- Vrednost = 1, !.
headache_race(Vrednost,1.0) :- Vrednost = 2, !.
headache_race(Vrednost,0.9) :- Vrednost = 3.



