loss_of_sensation_age(Vrednost, 0) :- Vrednost < 1, !.   
loss_of_sensation_age(Vrednost, 0) :- Vrednost >= 1, Vrednost =< 4, !.
loss_of_sensation_age(Vrednost, 0.1) :- Vrednost >= 5, Vrednost =< 14, !.
loss_of_sensation_age(Vrednost, 0.7) :- Vrednost >= 15, Vrednost =< 29, !.
loss_of_sensation_age(Vrednost, 1.4) :- Vrednost >= 30, Vrednost =< 44, !.
loss_of_sensation_age(Vrednost, 1.7) :- Vrednost >= 45, Vrednost =< 59, !.
loss_of_sensation_age(Vrednost, 1.2) :- Vrednost >= 60, Vrednost =< 74, !.
loss_of_sensation_age(Vrednost, 0.9) :- Vrednost >= 75.

loss_of_sensation_sex(Vrednost,1.0) :- Vrednost = 1, !.
loss_of_sensation_sex(Vrednost,1.0) :- Vrednost = 0.

loss_of_sensation_race(Vrednost,0.9) :- Vrednost = 0, !.
loss_of_sensation_race(Vrednost,0.8) :- Vrednost = 1, !.
loss_of_sensation_race(Vrednost,1.1) :- Vrednost = 2, !.
loss_of_sensation_race(Vrednost,0.9) :- Vrednost = 3.





