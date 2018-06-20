package com.example.cristina.calcolproject;

import java.util.ArrayList;

public class Separatore {

    public String toString() {
        String acc = "";
        for (String s : elementi) {
            acc += s + "  ";
        }
        return acc;
    }

    public ArrayList<String> getElementi() {
        return elementi;
    }

    final ArrayList<String> elementi = new ArrayList<>();

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

   /*
    public Double equal(int i ) {
        Espressione e = null;

        if (i == 0)
            e = Espressione.creaClassica(elementi);

        if (i == 1)
            e = Espressione.creaRPN(elementi);

        if (i == 2)
            e = Espressione.creaPolacca(elementi);

        return e.execute();
    }*/

    public void enter() {
        inviato = true;
    }

    public void cancellaTutto() {
        elementi.clear();
    }

    public void cancellaCifra() {
        if (elementi.size() == 0) return;

        int lastIndex = elementi.size() - 1;
        String lastElement = elementi.get(lastIndex);
        if (isNumber(lastElement)) {
            if (lastElement.length() > 1 )
            {
                elementi.set(lastIndex, lastElement.substring(0,lastElement.length()-1));
            } else
            {
                cancellaElemento();
            }
        } else
        {
            cancellaElemento();
        }
    }

    public void cancellaElemento() {

        if (elementi.size() > 0)
            elementi.remove(elementi.size()-1);
    }
}
