package sportsclub;

public abstract class AbstractMember implements Comparable<AbstractMember> {

    /** In jedem Verein muss der Name eindeutig sein */
    protected String name;

    public AbstractMember(String name) {
        this.name = name;
    }


    /**
     * berechnet die gesamten Einnahmen, die der Verein durch dieses
     * Mitglied pro Jahr erzielt. */
    abstract double getIncome();

    /**
     * berechnet die gesamten Ausgaben, die dieses Mitglied pro Jahr
     * verursacht.
     */
    abstract double getCosts();

    /**
     * berechnet den finanziellen Überschuss, den dieses Mitglied dem
     * Verein pro Jahr bringt.
     * */
    public double getSurplus() {
        return getIncome() - getCosts();
    }

    /**
     * gibt ordentlich formatiert und strukturiert (mit
     * Einrückungen im Fall einer Sektion) den Namen sowie Einnahmen, Ausgaben und
     * Überschuss des Mitglieds (der Mitglieder im Fall einer Sektion) zurück. Wenn ascending
     * true ist, soll die Ausgabe aufsteigend sortiert, ansonsten absteigend sortiert erfolgen. Die
     * */
    public String toString(boolean ascending) {
        return name + " | + " + getIncome() + " | - " + getCosts() + " | total " + getSurplus() + "\n";
    }


    /** Default-Methode String toString() soll eine Ausgabe in aufsteigender Reihenfolge erzeugen.
     * */
    @Override
    public String toString() {
        return toString(true);
    }

    public int compareTo(AbstractMember o) {
        if (o == null) throw new NullPointerException("Cannot compare to null"); // help from Claude
        else {
            String thisName = this.name.toLowerCase();
            String otherName = o.name.toLowerCase(); // if we compare lowercase 'a' and uppercase 'A' it would not be equal
            int minLength = Math.min(this.name.length(), o.name.length());

            for (int i = 0; i < minLength; i++) {  // compare each letter of the name to order
                if (thisName.charAt(i) < otherName.charAt(i))
                    return -1;  // this.name is before other.name in the alphabet
                if (thisName.charAt(i) > otherName.charAt(i)) return 1;
            }

            return Integer.compare(thisName.length(), otherName.length());
        }
    }

}
