package sportsclub;

abstract public class ActiveMember extends AbstractMember {

//    Aktive Mitglieder (Klasse ActiveMember): Diese Mitglieder besitzen einen ganzzahligen
//    Aktivitätsgrad im Bereich von 0 bis 10, und gliedern sich in:
//    o Spitzensportler (Klasse TopAthlete): Monatlicher Beitrag: €10,-, Ausgaben in € pro
//    Monat: Aktivitätsgrad * 5
//    o Amateure (Klasse AmateurAthlete): Monatlicher Beitrag: €25,- Ausgaben in € pro
//    Monat: Aktivitätsgrad * 2,5
//    o Trainer (Klasse Trainer): Monatlicher Beitrag: €10,- Ausgaben in € pro Monat:
//    Aktivitätsgrad * 40

    protected int activityLevel;

    protected ActiveMember(String name, int activityLevel) {
        super(name);
        if (activityLevel < 0 || activityLevel > 10) {        // invalid activity levels should not be ignored silently - help of AI, but it was my design decision
            throw new IllegalArgumentException("Activity level must be between 0 and 10");
        } else {
            this.activityLevel = activityLevel;
        }
    }

    @Override
    double getIncome() {
        return 12*getMonthlyIncome();  // *12 is in all subclasses the same, makes it easier to calculate income for each quarter etc.
    }

    abstract protected double getMonthlyIncome();           // abstract method implemented in each subclass

    @Override
    double getCosts() {
        return 12 * getMonthlyCosts();
    }

    abstract protected double getMonthlyCosts();




}
