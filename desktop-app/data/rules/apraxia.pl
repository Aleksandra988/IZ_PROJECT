apraxia_age(Vrednost, 15.5) :- Vrednost < 1, !.   
apraxia_age(Vrednost, 8.1) :- Vrednost >= 1, Vrednost =< 4, !.
apraxia_age(Vrednost, 5.7) :- Vrednost >= 5, Vrednost =< 14, !.
apraxia_age(Vrednost, 2.6) :- Vrednost >= 15, Vrednost =< 29, !.
apraxia_age(Vrednost, 2.7) :- Vrednost >= 30, Vrednost =< 44, !.
apraxia_age(Vrednost, 2.4) :- Vrednost >= 45, Vrednost =< 59, !.
apraxia_age(Vrednost, 3.5) :- Vrednost >= 60, Vrednost =< 74, !.
apraxia_age(Vrednost, 5.3) :- Vrednost >= 75.

apraxia_sex(Vrednost,1.2) :- Vrednost = 1, !.
apraxia_sex(Vrednost,0.9) :- Vrednost = 0.

apraxia_race(Vrednost,2.6) :- Vrednost = 0, !.
apraxia_race(Vrednost,3.4) :- Vrednost = 1, !.
apraxia_race(Vrednost,0.8) :- Vrednost = 2, !.
apraxia_race(Vrednost,9.4) :- Vrednost = 3.











