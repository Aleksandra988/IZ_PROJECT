problems_with_movement_age(Vrednost, 0.2) :- Vrednost < 1, !.   
problems_with_movement_age(Vrednost, 1.2) :- Vrednost >= 1, Vrednost =< 4, !.
problems_with_movement_age(Vrednost, 0.7) :- Vrednost >= 5, Vrednost =< 14, !.
problems_with_movement_age(Vrednost, 0.3) :- Vrednost >= 15, Vrednost =< 29, !.
problems_with_movement_age(Vrednost, 0.5) :- Vrednost >= 30, Vrednost =< 44, !.
problems_with_movement_age(Vrednost, 1) :- Vrednost >= 45, Vrednost =< 59, !.
problems_with_movement_age(Vrednost, 1.5) :- Vrednost >= 60, Vrednost =< 74, !.
problems_with_movement_age(Vrednost, 2.8) :- Vrednost >= 75.

problems_with_movement_sex(Vrednost,1.1) :- Vrednost = 1, !.
problems_with_movement_sex(Vrednost,0.9) :- Vrednost = 0.

problems_with_movement_race(Vrednost,1.1) :- Vrednost = 0, !.
problems_with_movement_race(Vrednost,0.7) :- Vrednost = 1, !.
problems_with_movement_race(Vrednost,1.1) :- Vrednost = 2, !.
problems_with_movement_race(Vrednost,0.8) :- Vrednost = 3.
