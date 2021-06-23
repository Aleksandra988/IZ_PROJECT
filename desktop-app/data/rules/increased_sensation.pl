increased_sensation_age(Vrednost, 0.3) :- Vrednost < 1, !.   
increased_sensation_age(Vrednost, 0.2) :- Vrednost >= 1, Vrednost =< 4, !.
increased_sensation_age(Vrednost, 0.1) :- Vrednost >= 5, Vrednost =< 14, !.
increased_sensation_age(Vrednost, 1.1) :- Vrednost >= 15, Vrednost =< 29, !.
increased_sensation_age(Vrednost, 2.2) :- Vrednost >= 30, Vrednost =< 44, !.
increased_sensation_age(Vrednost, 1.0) :- Vrednost >= 45, Vrednost =< 59, !.
increased_sensation_age(Vrednost, 0.1) :- Vrednost >= 60, Vrednost =< 74, !.
increased_sensation_age(Vrednost, 2.2) :- Vrednost >= 75.

increased_sensation_sex(Vrednost,0.9) :- Vrednost = 1, !.
increased_sensation_sex(Vrednost,1.0) :- Vrednost = 0.

increased_sensation_race(Vrednost,1.1) :- Vrednost = 0, !.
increased_sensation_race(Vrednost,0.1) :- Vrednost = 1, !.
increased_sensation_race(Vrednost,1.3) :- Vrednost = 2, !.
increased_sensation_race(Vrednost,0.2) :- Vrednost = 3.






