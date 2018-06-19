package com.example.cristina.calcolproject;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EspressioneUnitTest {

    @Test
    public void testEspressioneClassica1() {
        ArrayList<String> as= new ArrayList<>();

        as.add("10");

        Espressione e = Espressione.creaClassica(as);

        assertEquals(e.execute() , new Double(10.0));
    }

    @Test
    public void testEspressioneClassica2() {
        ArrayList<String> as= new ArrayList<>();

        as.add("10");
        as.add("+");
        as.add("10");

        Espressione e = Espressione.creaClassica(as);

        assertEquals(e.execute() , new Double(20.0));
    }

    @Test
    public void testEspressioneClassica3() {
        ArrayList<String> as= new ArrayList<>();

        as.add("1");
        as.add("+");
        as.add("2");
        as.add("-");
        as.add("3");

        Espressione e = Espressione.creaClassica(as);

        assertEquals(e.execute() , new Double(0.0));
    }

    @Test
    public void testEspressioneClassica4() {
        ArrayList<String> as= new ArrayList<>();

        as.add("1");
        as.add("*");
        as.add("2");
        as.add("/");
        as.add("3");

        Espressione e = Espressione.creaClassica(as);

        assertEquals(e.execute() , new Double(2.0/3.0));
    }

    @Test
    public void testEspressioneRPN1() {
        ArrayList<String> as= new ArrayList<>();

        as.add("1");
        as.add("2");
        as.add("+");

        Espressione e = Espressione.creaRPN(as);

        assertEquals(e.execute() , new Double(3.0));
    }

    @Test
    public void testEspressioneRPN2() {
        ArrayList<String> as= new ArrayList<>();

        as.add("1");
        as.add("2");
        as.add("*");

        Espressione e = Espressione.creaRPN(as);

        assertEquals(e.execute() , new Double(2.0));
    }

    @Test
    public void testEspressioneRPN3() {
        ArrayList<String> as= new ArrayList<>();

        as.add("3");
        as.add("2");
        as.add("*");
        as.add("2");
        as.add("3");
        as.add("-");
        as.add("/");

        Espressione e = Espressione.creaRPN(as);

        assertEquals(e.execute() , new Double(-6.0));
    }

}
