package tests;

import org.junit.Test;

import calcolproject.separatore.Separatore;

import static org.junit.Assert.assertEquals;

public class SeparatoreUnitTest {

    @Test
    public void testSeparatoreSomma() {

        Separatore s = new Separatore();

        s.addNumber("2");
        s.addNumber("5");
        s.addOperator("+");
        s.addNumber("1");
        s.addNumber("2");

        assertEquals(s.toString(), "25  +  12  ");

    }

    @Test
    public void testSeparatoreEnter() {

        Separatore s = new Separatore();
        s.enter();
        s.addNumber("2");
        s.enter();
        s.addNumber("5");
        s.enter();
        s.addOperator("+");
        s.enter();
        s.addNumber("1");
        s.addNumber("2");
        s.enter();

        assertEquals(s.toString(), "2  5  +  12  ");

    }

    @Test
    public void testSeparatoreVirgola() {

        Separatore s = new Separatore();

        s.addNumber("2");
        s.addNumber(".");
        s.addNumber("5");
        s.addOperator("+");
        s.addNumber("1");
        s.addNumber("2");
        s.addOperator("+");
        s.addNumber("1");
        s.addNumber(".");


        assertEquals(s.toString(), "2.5  +  12  +  1.  ");

    }


}
