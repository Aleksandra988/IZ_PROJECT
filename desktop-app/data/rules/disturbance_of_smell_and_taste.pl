disturbance_of_smell_and_taste_age(Vrednost, 0.4) :- Vrednost < 1, !.   
disturbance_of_smell_and_taste_age(Vrednost, 0) :- Vrednost >= 1, Vrednost =< 4, !.
disturbance_of_smell_and_taste_age(Vrednost, 0.2) :- Vrednost >= 5, Vrednost =< 14, !.
disturbance_of_smell_and_taste_age(Vrednost, 0.6) :- Vrednost >= 15, Vrednost =< 29, !.
disturbance_of_smell_and_taste_age(Vrednost, 0.9) :- Vrednost >= 30, Vrednost =< 44, !.
disturbance_of_smell_and_taste_age(Vrednost, 1.5) :- Vrednost >= 45, Vrednost =< 59, !.
disturbance_of_smell_and_taste_age(Vrednost, 2.0) :- Vrednost >= 60, Vrednost =< 74, !.
disturbance_of_smell_and_taste_age(Vrednost, 1.0) :- Vrednost >= 75.

disturbance_of_smell_and_taste_sex(Vrednost,1.2) :- Vrednost = 1, !.
disturbance_of_smell_and_taste_sex(Vrednost,0.8) :- Vrednost = 0.

disturbance_of_smell_and_taste_race(Vrednost,1.4) :- Vrednost = 0, !.
disturbance_of_smell_and_taste_race(Vrednost,0.2) :- Vrednost = 1, !.
disturbance_of_smell_and_taste_race(Vrednost,1.1) :- Vrednost = 2, !.
disturbance_of_smell_and_taste_race(Vrednost,1.0) :- Vrednost = 3.








