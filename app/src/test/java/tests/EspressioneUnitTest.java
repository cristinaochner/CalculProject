package tests;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;

import calcolproject.espressione.Espressione;

public class EspressioneUnitTest {

    @Test
    public void testEspressioneClassica1() {
        ArrayList<String> as = new ArrayList<>();

        as.add("10");

        Espressione e = Espressione.creaClassica(as);

        Assert.assertEquals(e.execute(), Double.valueOf(10.0));
    }

    @Test
    public void testEspressioneClassica2() {
        ArrayList<String> as = new ArrayList<>();

        as.add("10");
        as.add("+");
        as.add("10");

        Espressione e = Espressione.creaClassica(as);

        Assert.assertEquals(e.execute(), Double.valueOf(20.0));
    }

    @Test
    public void testEspressioneClassica3() {
        ArrayList<String> as = new ArrayList<>();

        as.add("1");
        as.add("+");
        as.add("2");
        as.add("-");
        as.add("3");

        Espressione e = Espressione.creaClassica(as);

        Assert.assertEquals(e.execute(), Double.valueOf(0.0));
    }

    @Test
    public void testEspressioneClassica4() {
        ArrayList<String> as = new ArrayList<>();

        as.add("1");
        as.add("*");
        as.add("2");
        as.add("/");
        as.add("3");

        Espressione e = Espressione.creaClassica(as);

        Assert.assertEquals(e.execute(), Double.valueOf(2.0 / 3.0));
    }

    @Test
    public void testEspressioneRPN1() {
        ArrayList<String> as = new ArrayList<>();

        as.add("1");
        as.add("2");
        as.add("+");

        Espressione e = Espressione.creaRPN(as);

        Assert.assertEquals(e.execute(), Double.valueOf(3.0));
    }

    @Test
    public void testEspressioneRPN2() {
        ArrayList<String> as = new ArrayList<>();

        as.add("1");
        as.add("2");
        as.add("*");

        Espressione e = Espressione.creaRPN(as);

        Assert.assertEquals(e.execute(), Double.valueOf(2.0));
    }

    @Test
    public void testEspressioneRPN3() {
        ArrayList<String> as = new ArrayList<>();

        as.add("3");
        as.add("2");
        as.add("*");
        as.add("2");
        as.add("3");
        as.add("-");
        as.add("/");

        Espressione e = Espressione.creaRPN(as);

        Assert.assertEquals(e.execute(), Double.valueOf(-6.0));
    }

}
