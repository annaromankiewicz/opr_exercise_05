package sportsclub;

public class Section extends AbstractMember {

    BinarySearchTree<AbstractMember> section;

    public Section(String name) {
        super(name);
        section = new BinarySearchTree<AbstractMember>();
    }

    @Override
    double getIncome() {
        AbstractMember[] sectionArray = section.toArray(new AbstractMember[section.size()], true); // I changed the signature of toArray in BST to avoid a typecast
        double sum = 0;
        for (AbstractMember member : sectionArray) {
            sum += member.getIncome();
        }
        return sum;
    }

    @Override
    double getCosts() {
        AbstractMember[] sectionArray = section.toArray(new AbstractMember[section.size()], true);
        double sum = 0;
        for (AbstractMember abstractMember : sectionArray) {
            sum += abstractMember.getCosts();
        }
        return sum;
    }

    @Override
    public String toString(boolean ascending) {
        StringBuilder s = new StringBuilder();
        AbstractMember[] sectionArray = section.toArray(new AbstractMember[section.size()], true); // I changed the signature of toArray in BST to avoid a typecast
        s.append(super.toString(true)); // Section Name
        for (AbstractMember member: sectionArray) {
            s.append(member.toString(true));
        }
        return s.toString();
    }

    boolean addMember(AbstractMember m) {
        return section.insert(m);
    }

    boolean removeMember(AbstractMember m) {
        return section.remove(m);
    }

    boolean isMember(AbstractMember m) {
        return section.find(m);
    }

}

