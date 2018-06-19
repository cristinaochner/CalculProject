package com.example.cristina.calcolproject;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Espressione {

    abstract Double execute();

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static Espressione creaClassica(ArrayList<String> elementi) {
        if (elementi.size() == 1) {
            String primoElemento = elementi.get(0);
            Double d = Double.parseDouble(primoElemento);
            Numero n = new Numero(d);
            return n;
        }

        if (elementi.contains("+")) {
            int index = elementi.indexOf("+");
            ArrayList<String> arraySinistra = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> arrayDestra = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));

            Espressione espressioneSinistra = creaClassica(arraySinistra);
            Espressione espressioneDestra = creaClassica(arrayDestra);

            return new Add(espressioneSinistra, espressioneDestra);

        } else if (elementi.contains("-")) {
            int index = elementi.indexOf("-");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Sub(creaClassica(left), creaClassica(right));
        } else if (elementi.contains("*")) {
            int index = elementi.indexOf("*");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Mol(creaClassica(left), creaClassica(right));
        } else {
            int index = elementi.indexOf("/");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Div(creaClassica(left), creaClassica(right));
        }
    }
    
    public static Espressione creaRPN(ArrayList<String> elementi) {
        Stack<Espressione> stack = new Stack<>();

        for (String s : elementi) {
            if (isNumber(s)) {
                stack.add(new Numero(Double.parseDouble(s)));
            } else if (s.equals("+")) {
                Espressione e1 = stack.pop();
                Espressione e2 = stack.pop();
                Espressione somma = new Add(e2, e1);
                stack.add(somma);
            } else if (s.equals("*")) {
                Espressione e1 = stack.pop();
                Espressione e2 = stack.pop();
                stack.push(new Mol(e2, e1));
            } else if (s.equals("-")) {
                Espressione e1 = stack.pop();
                Espressione e2 = stack.pop();
                stack.push(new Sub(e2, e1));
            } else if (s.equals("/")) {
                Espressione e1 = stack.pop();
                Espressione e2 = stack.pop();
                stack.push(new Div(e2, e1));
            }
        }
        return stack.pop();
    }
    
    public static Espressione creaPolacca(ArrayList<String> elementi) {
        ArrayList<String> elementiInversa = new ArrayList<>();
        for (String s : elementi) {
            elementiInversa.add(0, s);
        }
        return  creaRPN(elementiInversa);
    }
}

