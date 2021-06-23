focal_weakness_age(Vrednost, 0) :- Vrednost < 1, !.   
focal_weakness_age(Vrednost, 0.1) :- Vrednost >= 1, Vrednost =< 4, !.
focal_weakness_age(Vrednost, 0.2) :- Vrednost >= 5, Vrednost =< 14, !.
focal_weakness_age(Vrednost, 0.3) :- Vrednost >= 15, Vrednost =< 29, !.
focal_weakness_age(Vrednost, 0.7) :- Vrednost >= 30, Vrednost =< 44, !.
focal_weakness_age(Vrednost, 1.3) :- Vrednost >= 45, Vrednost =< 59, !.
focal_weakness_age(Vrednost, 1.7) :- Vrednost >= 60, Vrednost =< 74, !.
focal_weakness_age(Vrednost, 2.9) :- Vrednost >= 75.

focal_weakness_sex(Vrednost,1.0) :- Vrednost = 1, !.
focal_weakness_sex(Vrednost,1.0) :- Vrednost = 0.

focal_weakness_race(Vrednost,1.2) :- Vrednost = 0, !.
focal_weakness_race(Vrednost,0.7) :- Vrednost = 1, !.
focal_weakness_race(Vrednost,1.0) :- Vrednost = 2, !.
focal_weakness_race(Vrednost,1.9) :- Vrednost = 3.










