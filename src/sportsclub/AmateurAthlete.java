package sportsclub;

public class AmateurAthlete extends ActiveMember {

    protected AmateurAthlete(String name, int activityLevel) {
        super(name, activityLevel);
    }

    //    Aktive Mitglieder (Klasse ActiveMember): Diese Mitglieder besitzen einen ganzzahligen
//    Aktivitätsgrad im Bereich von 0 bis 10, und gliedern sich in:
//    o Amateure (Klasse AmateurAthlete): Monatlicher Beitrag: €25,- Ausgaben in € pro
//    Monat: Aktivitätsgrad * 2,5
//    o Trainer (Klasse Trainer): Monatlicher Beitrag: €10,- Ausgaben in € pro Monat:
//    Aktivitätsgrad * 40

//    @Override
//    double getIncome() {
//        return 12*25;
//    }

    @Override
    protected double getMonthlyIncome() {
        return 25;
    }

//    @Override
//    double getCosts() {
//        return 12*activityLevel * 2.5;
//    }

    @Override
    protected double getMonthlyCosts() {
        return activityLevel * 2.5;
    }

//    @Override
//    String toString(boolean ascending) {
//        return "";
//    }

}

