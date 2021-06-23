dizziness_age(Vrednost, 0) :- Vrednost < 1, !.   
dizziness_age(Vrednost, 0.1) :- Vrednost >= 1, Vrednost =< 4, !.
dizziness_age(Vrednost, 0.4) :- Vrednost >= 5, Vrednost =< 14, !.
dizziness_age(Vrednost, 0.9) :- Vrednost >= 15, Vrednost =< 29, !.
dizziness_age(Vrednost, 1.0) :- Vrednost >= 30, Vrednost =< 44, !.
dizziness_age(Vrednost, 1.2) :- Vrednost >= 45, Vrednost =< 59, !.
dizziness_age(Vrednost, 1.4) :- Vrednost >= 60, Vrednost =< 74, !.
dizziness_age(Vrednost, 1.8) :- Vrednost >= 75.

dizziness_sex(Vrednost,0.9) :- Vrednost = 1, !.
dizziness_sex(Vrednost,1.1) :- Vrednost = 0.

dizziness_race(Vrednost,0.9) :- Vrednost = 0, !.
dizziness_race(Vrednost,0.9) :- Vrednost = 1, !.
dizziness_race(Vrednost,1.0) :- Vrednost = 2, !.
dizziness_race(Vrednost,1.1) :- Vrednost = 3.









