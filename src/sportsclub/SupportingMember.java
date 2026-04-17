package sportsclub;

public class SupportingMember extends AbstractMember {

    public SupportingMember(String name) {
        super(name);
    }

//    Unterstützende Mitglieder (Klasse SupportingMember): Diese Mitglieder bezahlen einen
//    Jahresbeitrag von €100,- und verursachen bei Vereinsfesten Ausgaben von durchschnittlich
//    €15,- pro Jahr.

    @Override
    double getIncome() {
        return 100;
    }

    @Override
    double getCosts() {
        return 15;
    }



}

