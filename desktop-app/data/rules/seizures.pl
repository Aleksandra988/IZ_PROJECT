seizures_age(Vrednost, 0.7) :- Vrednost < 1, !.   
seizures_age(Vrednost, 1.5) :- Vrednost >= 1, Vrednost =< 4, !.
seizures_age(Vrednost, 1.5) :- Vrednost >= 5, Vrednost =< 14, !.
seizures_age(Vrednost, 1.2) :- Vrednost >= 15, Vrednost =< 29, !.
seizures_age(Vrednost, 1.1) :- Vrednost >= 30, Vrednost =< 44, !.
seizures_age(Vrednost, 1.0) :- Vrednost >= 45, Vrednost =< 59, !.
seizures_age(Vrednost, 0.6) :- Vrednost >= 60, Vrednost =< 74, !.
seizures_age(Vrednost, 0.4) :- Vrednost >= 75.

seizures_sex(Vrednost,1.2) :- Vrednost = 1, !.
seizures_sex(Vrednost,0.8) :- Vrednost = 0.

seizures_race(Vrednost,1.2) :- Vrednost = 0, !.
seizures_race(Vrednost,1.0) :- Vrednost = 1, !.
seizures_race(Vrednost,0.9) :- Vrednost = 2, !.
seizures_race(Vrednost,0.9) :- Vrednost = 3.


