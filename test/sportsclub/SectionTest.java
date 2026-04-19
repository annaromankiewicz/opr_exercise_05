package sportsclub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {

    Section sportUnion = new Section("SportUnion");
    Section footballClub = new Section("Football");
    Section footballU20 = new Section("U20");
    Section sectionEmpty = new Section("Volleyball");

    @BeforeEach
    void setUp() {
        // ActiveMembers as AbstractMember
        AbstractMember trainer = new Trainer("Anna", 10);
        AbstractMember amateurAthlete1 = new AmateurAthlete("Julia", 2);
        AbstractMember amateurAthlete2 = new AmateurAthlete("Paula", 3);
        AbstractMember amateurAthlete3 = new AmateurAthlete("Kathi", 4);
        AbstractMember topAthlete1 = new TopAthlete("Luise", 5);
        AbstractMember topAthlete2 = new TopAthlete("Judith", 6);


        AbstractMember honoraryMember = new HonoraryMember("Hubert");
        AbstractMember chairMember = new ChairMember("Susi", 9);

        //
        footballClub.addMember(honoraryMember);
        footballClub.addMember(chairMember);
        footballClub.addMember(topAthlete1);
        footballClub.addMember(topAthlete2);

        footballU20.addMember(trainer);
        footballU20.addMember(amateurAthlete1);
        footballU20.addMember(amateurAthlete2);
        footballU20.addMember(amateurAthlete3);
    }

    @Test
    void testGetIncome() {
        // Trainer
        Trainer alice = new Trainer("Alice", 5);
        assertEquals(120, alice.getIncome());

        // TopAthlete
        TopAthlete max = new TopAthlete("Max", 5);
        assertEquals(120, max.getIncome());

        // AmateurAthlete
        AmateurAthlete lisa = new AmateurAthlete("Lisa", 4);
        assertEquals(300, lisa.getIncome());

        // SupportingMember
        SupportingMember bob = new SupportingMember("Bob");
        assertEquals(100, bob.getIncome());

        // HonoraryMember
        HonoraryMember karl = new HonoraryMember("Karl");
        assertEquals(0, karl.getIncome());

        // ChairMember
        ChairMember eva = new ChairMember("Eva", 9);
        assertEquals(900, eva.getIncome());

        // Section
        assertEquals(1020, footballU20.getIncome());

        // Empty Section
        assertEquals(0, sectionEmpty.getIncome());
    }

    @Test
    void testGetCosts() {
        // Trainer
        Trainer alice = new Trainer("Alice", 5);
        assertEquals(2400, alice.getCosts());

        // TopAthlete
        TopAthlete max = new TopAthlete("Max", 5);
        assertEquals(300, max.getCosts());

        // AmateurAthlete
        AmateurAthlete lisa = new AmateurAthlete("Lisa", 4);
        assertEquals(120, lisa.getCosts());

        // SupportingMember
        SupportingMember bob = new SupportingMember("Bob");
        assertEquals(15, bob.getCosts());

        // HonoraryMember
        HonoraryMember karl = new HonoraryMember("Karl");
        assertEquals(20, karl.getCosts());

        // ChairMember
        ChairMember eva = new ChairMember("Eva", 9);
        assertEquals(180, eva.getCosts());

        // Section
        assertEquals(5070, footballU20.getCosts());

        // Empty Section
        assertEquals(0, sectionEmpty.getCosts());

        // Boundary: min activity
        Trainer tMin = new Trainer("Min", 0);
        assertEquals(0, tMin.getCosts());

        // Boundary: max activity
        Trainer tMax = new Trainer("Max", 10);
        assertEquals(4800, tMax.getCosts());
    }

    @Test
    void testGetSurplus() {
        // Trainer
        Trainer alice = new Trainer("Alice", 5);
        assertEquals(-2280, alice.getSurplus());

        // TopAthlete
        TopAthlete max = new TopAthlete("Max", 5);
        assertEquals(-180, max.getSurplus());

        // AmateurAthlete
        AmateurAthlete lisa = new AmateurAthlete("Lisa", 4);
        assertEquals(180, lisa.getSurplus());

        // SupportingMember
        SupportingMember bob = new SupportingMember("Bob");
        assertEquals(85, bob.getSurplus());

        // HonoraryMember
        HonoraryMember karl = new HonoraryMember("Karl");
        assertEquals(-20, karl.getSurplus());

        // ChairMember
        ChairMember eva = new ChairMember("Eva", 9);
        assertEquals(720, eva.getSurplus());

        // Section
        assertEquals(-4050, footballU20.getSurplus());

        // Empty Section
        assertEquals(0, sectionEmpty.getSurplus());
    }

    @Test
    void activityLevelBoundaries() {
        Trainer tMin = new Trainer("Min", 0);
        assertEquals(0, tMin.getCosts());

        Trainer tMax = new Trainer("Max", 10);
        assertEquals(4800, tMax.getCosts());
    }

    @Test
    void activityLevelInvalid() {
        // Negative activity level
        assertThrows(IllegalArgumentException.class,
                () -> new Trainer("Neg", -1));          // help of AI

        // Over maximum activity level
        assertThrows(IllegalArgumentException.class,
                () -> new Trainer("Over", 11));
    }

    @Test
    void competenceLevelInvalid() {
        // Negative activity level
        assertThrows(IllegalArgumentException.class,
                () -> new ChairMember("Neg", -1));          // help of AI

        // Over maximum activity level
        assertThrows(IllegalArgumentException.class,
                () -> new ChairMember("Over", 11));
    }


    @Test
    void compareToSameNameDifferentCase() {
        AbstractMember m1 = new TopAthlete("anna", 5);
        AbstractMember m2 = new TopAthlete("Anna", 5);
        assertEquals(0, m1.compareTo(m2));
    }

    @Test
    void compareToSelf() {
        AbstractMember m1 = new TopAthlete("Luise", 5);
        assertEquals(0, m1.compareTo(m1));
    }


    @Test
    void insertMemberActive() {
        AbstractMember topAthlete1 = new TopAthlete("Luise", 5);
        AbstractMember topAthlete2 = new TopAthlete("Judith", 6);
        AbstractMember topAthlete3 = new TopAthlete("Jo", 7);
        AbstractMember topAthlete4 = new TopAthlete("Josef", 8);

        // insert double
        assertFalse(footballClub.addMember(topAthlete1));
        assertFalse(footballClub.addMember(topAthlete2));


        assertTrue(footballClub.addMember(topAthlete3));
        assertTrue(footballClub.addMember(topAthlete4));

        // insert section

        assertTrue(footballClub.addMember(footballU20));

        // insert duplicate
        AbstractMember topAthlete6 = new TopAthlete("Paul", 10);
        AbstractMember topAthlete6dup = new TopAthlete("Paul", 10);

        assertTrue(footballClub.addMember(topAthlete6));
        assertFalse(footballClub.addMember(topAthlete6dup));
    }

    @Test
    void removeEmpty() {
        assertFalse(sectionEmpty.removeMember(new TopAthlete("Paul", 10)));
    }


    @Test
    void removeMember() {
        AbstractMember trainer = new Trainer("Anna", 10);
        AbstractMember amateurAthlete1 = new AmateurAthlete("Julia", 2);
        AbstractMember amateurAthlete2 = new AmateurAthlete("Paula", 3);

        assertTrue(footballU20.isMember(trainer));
        assertTrue(footballU20.removeMember(trainer));
        assertFalse(footballU20.isMember(trainer));

        assertTrue(footballU20.isMember(amateurAthlete1));
        assertTrue(footballU20.removeMember(amateurAthlete1));
        assertFalse(footballU20.isMember(amateurAthlete1));

        assertTrue(footballU20.isMember(amateurAthlete2));
        assertTrue(footballU20.removeMember(amateurAthlete2));
        assertFalse(footballU20.isMember(amateurAthlete2));

    }

    @Test
    void removeSection() {
     sportUnion.addMember(footballClub);

        assertTrue(sportUnion.isMember(footballClub));
        assertTrue(sportUnion.removeMember(footballClub));
        assertFalse(sportUnion.isMember(footballClub));

    }



    @Test
    void isMemberEmptySection() {
        assertFalse(sectionEmpty.isMember(new TopAthlete("Laura", 3)));
    }

    @Test
    void isMemberPerson() {
        AbstractMember topAthlete1 = new TopAthlete("Luise", 5);
        AbstractMember topAthlete2 = new TopAthlete("Judith", 6);
        assertFalse(sportUnion.isMember(topAthlete1));
        assertTrue(sportUnion.addMember(topAthlete1));
        assertTrue(sportUnion.isMember(topAthlete1));

        assertFalse(sportUnion.isMember(topAthlete2));
        assertTrue(sportUnion.addMember(topAthlete2));
        assertTrue(sportUnion.isMember(topAthlete2));

    }

    @Test
    void isMemberSection() {
        assertFalse(sportUnion.isMember(footballU20));
        assertTrue(sportUnion.addMember(footballU20));
        assertTrue(sportUnion.isMember(footballU20));

        assertFalse(sportUnion.isMember(footballClub));
        assertTrue(sportUnion.addMember(footballClub));
        assertTrue(sportUnion.isMember(footballClub));

    }

    @Test
    void compareTo() {
        AbstractMember topAthlete3 = new TopAthlete("Jo", 7);
        AbstractMember topAthlete4 = new TopAthlete("Josef", 8);
        AbstractMember topAthlete5 = new TopAthlete("Josef", 9);
        assertEquals(-1, topAthlete3.compareTo(topAthlete4));
        assertEquals(1, topAthlete4.compareTo(topAthlete3));
        assertEquals(0, topAthlete4.compareTo(topAthlete5));
    }

    @Test
    void getIncome() {
        assertEquals(1020, footballU20.getIncome());
    }

    @Test
    void getCosts() {
        assertEquals(5070, footballU20.getCosts());
    }

    @Test
    void getSurplus() {
        assertEquals(-4050, footballU20.getSurplus());
    }


    @Test
    void testToStringMembers() {
        AbstractMember topAthlete1 = new TopAthlete("Luise", 5);
        AbstractMember topAthlete2 = new TopAthlete("Judith", 6);
        System.out.print(topAthlete1.toString());
        System.out.print(topAthlete2.toString());
    }

    @Test
    void compareToObjectNull() {
        AbstractMember topAthlete1 = new TopAthlete("Luise", 5);
        AbstractMember topAthlete2 = null;

        assertThrows(NullPointerException.class, () -> {
            topAthlete1.compareTo(topAthlete2);
        });
    }

    @Test
    void testToStringSection() {
        System.out.print(footballU20.toString(true));
    }

    @Test
    void testToStringSectionOfSection() {
        sportUnion.addMember(footballClub);
        footballClub.addMember(footballU20);

        System.out.print("-------------" + "A-Z" + "-------------\n");

        System.out.print(sportUnion.toString(true));

        System.out.print("-------------" + "A-Z" + "-------------\n");

        System.out.print(sportUnion.toString());


        System.out.print("-------------" + "Z-A" + "-------------\n");
        System.out.print(sportUnion.toString(false));
    }


}
