package com.example.cristina.calcolproject;

import android.media.session.MediaSession;

import java.util.ArrayList;

public class Separatore {

    public String toString() {
        String acc = "";
        for (String s : elementi) {
            acc += s + "  ";
        }
        return acc;
    }

    ArrayList<String> elementi = new ArrayList<>();
    boolean inviato = false;

    public void addNumber(String s) {
        if (elementi.size() == 0) {
            elementi.add(s);
            return;
        }

        int lastIndex = elementi.size() - 1;
        String lastElement = elementi.get(lastIndex);

        if (isNumber(lastElement) && inviato == false) {
            elementi.set(lastIndex, lastElement + s);
        } else {
            elementi.add(s);
            inviato = false;
        }
    }

    public void addOperator(String s) {
        elementi.add(s);
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Double equal(int i ) {
        Expression e = null;

        if (i == 0)
            e = Expression.algebraic(elementi);

        if (i == 1)
            e = Expression.polacca1(elementi);

        if (i == 2)
            e = Expression.polacca2(elementi);

        return e.execute();
    }

    public void enter() {
        inviato = true;
    }
}
