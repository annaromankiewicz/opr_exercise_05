package sportsclub;

public class ChairMember extends AbstractMember {

    /** Vorstandsmitglieder haben einen
     ganzzahligen Kompetenzwert im Bereich von 0 und 10. Ein Vorstandsmitglied erzeugt durch
     das Lukrieren von Sponsorengeldern und Förderungen Jahreseinnahmen von Kompetenz *
     100 € und verursacht Ausgaben, indem es 20% Provision für lukrierte Einnahmen erhält.
     */

    protected int competenceValue;

    public ChairMember(String name, int competenceValue) {
        super(name);
        if (competenceValue >= 0 && competenceValue <= 10) {
            this.competenceValue = competenceValue;
        }
    }

    @Override
    double getIncome() {
        return competenceValue *100;
    }

    @Override
    double getCosts() {
        return getIncome()*0.2;
    }

//    @Override
//    double getSurplus() {
//        return getIncome()-getCosts();
//    }

//    @Override
//    String toString(boolean ascending) {
//        return "";
//    }

//    @Override
//    public int compareTo(AbstractMember o) {
//        ChairMember other = (ChairMember) o;
//        return this.competenceValue-other.competenceValue;
//    }
}

