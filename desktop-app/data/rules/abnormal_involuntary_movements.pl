abnormal_involuntary_movements_age(Vrednost, 0.9) :- Vrednost < 1, !.   
abnormal_involuntary_movements_age(Vrednost, 0.7) :- Vrednost >= 1, Vrednost =< 4, !.
abnormal_involuntary_movements_age(Vrednost, 0.8) :- Vrednost >= 5, Vrednost =< 14, !.
abnormal_involuntary_movements_age(Vrednost, 0.6) :- Vrednost >= 15, Vrednost =< 29, !.
abnormal_involuntary_movements_age(Vrednost, 0.8) :- Vrednost >= 30, Vrednost =< 44, !.
abnormal_involuntary_movements_age(Vrednost, 1.1) :- Vrednost >= 45, Vrednost =< 59, !.
abnormal_involuntary_movements_age(Vrednost, 1.4) :- Vrednost >= 60, Vrednost =< 74, !.
abnormal_involuntary_movements_age(Vrednost, 1.8) :- Vrednost >= 75.

abnormal_involuntary_movements_sex(Vrednost,1.1) :- Vrednost = 1, !.
abnormal_involuntary_movements_sex(Vrednost,0.9) :- Vrednost = 0.

abnormal_involuntary_movements_race(Vrednost,0.7) :- Vrednost = 0, !.
abnormal_involuntary_movements_race(Vrednost,0.8) :- Vrednost = 1, !.
abnormal_involuntary_movements_race(Vrednost,1.1) :- Vrednost = 2, !.
abnormal_involuntary_movements_race(Vrednost,0.9) :- Vrednost = 3.

