package sportsclub;

public class HonoraryMember extends AbstractMember {

    public HonoraryMember(String name) {
        super(name);
    }

    @Override
    double getIncome() {
        return 0;
    }

    @Override
    double getCosts() {
        return 20;
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
//       return 0;
//    }
}

