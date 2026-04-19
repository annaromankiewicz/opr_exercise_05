package sportsclub;

public class TopAthlete extends ActiveMember {

    protected TopAthlete(String name, int activityLevel) {
        super(name, activityLevel);
    }

    //    Aktive Mitglieder (Klasse ActiveMember): Diese Mitglieder besitzen einen ganzzahligen
//    Aktivitätsgrad im Bereich von 0 bis 10, und gliedern sich in:
//    o Spitzensportler (Klasse TopAthlete): Monatlicher Beitrag: €10,-, Ausgaben in € pro
//    Monat: Aktivitätsgrad * 5


    @Override
    protected double getMonthlyIncome() {
        return 10;
    }


    @Override
    protected double getMonthlyCosts() {
        return activityLevel * 5;
    }


}

