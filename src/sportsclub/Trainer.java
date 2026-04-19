package sportsclub;

public class Trainer extends ActiveMember {
    protected Trainer(String name, int activityLevel) {
        super(name, activityLevel);
    }

    //    Aktive Mitglieder (Klasse ActiveMember): Diese Mitglieder besitzen einen ganzzahligen
//    Aktivitätsgrad im Bereich von 0 bis 10, und gliedern sich in:

//    o Trainer (Klasse Trainer): Monatlicher Beitrag: €10,- Ausgaben in € pro Monat:
//    Aktivitätsgrad * 40


    @Override
    protected double getMonthlyIncome() {
        return 10;
    }


    @Override
    protected double getMonthlyCosts() {
        return activityLevel * 40;
    }


}

