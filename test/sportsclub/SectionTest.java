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
    void testMethods() {
        Trainer alice = new Trainer("Alice", 5);
        assertEquals(120, alice.getIncome());
        assertEquals(2400, alice.getCosts());
        assertEquals(-2280, alice.getSurplus());
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
    void removeMember() {
        AbstractMember trainer = new Trainer("Anna", 10);
        AbstractMember amateurAthlete1 = new AmateurAthlete("Julia", 2);
        AbstractMember amateurAthlete2 = new AmateurAthlete("Paula", 3);

        assertTrue(footballU20.isMember(trainer));
        assertTrue(footballU20.removeMember(trainer));
        assertFalse(footballU20.isMember(trainer));

    }

    @Test
    void isMemberEmptySection() {
        assertFalse(sportUnion.isMember(new TopAthlete("Laura", 3)));
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
    void isMemberPersonSection() {
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
        footballClub.addMember(footballU20);
        System.out.print(footballClub.toString(true));
    }


}
