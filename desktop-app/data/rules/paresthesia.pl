paresthesia_age(Vrednost, 0) :- Vrednost < 1, !.   
paresthesia_age(Vrednost, 0) :- Vrednost >= 1, Vrednost =< 4, !.
paresthesia_age(Vrednost, 0.3) :- Vrednost >= 5, Vrednost =< 14, !.
paresthesia_age(Vrednost, 0.7) :- Vrednost >= 15, Vrednost =< 29, !.
paresthesia_age(Vrednost, 1.3) :- Vrednost >= 30, Vrednost =< 44, !.
paresthesia_age(Vrednost, 1.5) :- Vrednost >= 45, Vrednost =< 59, !.
paresthesia_age(Vrednost, 1.3) :- Vrednost >= 60, Vrednost =< 74, !.
paresthesia_age(Vrednost, 1.0) :- Vrednost >= 75.

paresthesia_sex(Vrednost,0.9) :- Vrednost = 1, !.
paresthesia_sex(Vrednost,1.1) :- Vrednost = 0.

paresthesia_race(Vrednost,1.1) :- Vrednost = 0, !.
paresthesia_race(Vrednost,0.7) :- Vrednost = 1, !.
paresthesia_race(Vrednost,1.1) :- Vrednost = 2, !.
paresthesia_race(Vrednost,0.8) :- Vrednost = 3.







