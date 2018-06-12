package com.example.cristina.calcolproject;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Expression {

    abstract Double execute();

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Expression polacca1(ArrayList<String> elementi) {
        Stack<Expression> stack = new Stack<>();

        for (String s : elementi) {
            if (isNumber(s)) {
                stack.add(new Number(Double.parseDouble(s)));
            } else if (s.equals("+")) {
                Expression e1 = stack.pop();
                Expression e2 = stack.pop();
                stack.push(new Add(e2, e1));
            } else if (s.equals("*")) {
                Expression e1 = stack.pop();
                Expression e2 = stack.pop();
                stack.push(new Mul(e2, e1));
            } else if (s.equals("-")) {
                Expression e1 = stack.pop();
                Expression e2 = stack.pop();
                stack.push(new Sub(e2, e1));
            } else if (s.equals("/")) {
                Expression e1 = stack.pop();
                Expression e2 = stack.pop();
                stack.push(new Div(e2, e1));
            }
        }
        return stack.pop();
    }

    public static Expression polacca2(ArrayList<String> elementi) {
        ArrayList<String> elementiInversa = new ArrayList<>();
        for (String s : elementi) {
            elementiInversa.add(0, s);
        }
        return  polacca1(elementiInversa);
    }

    public static Expression algebraic(ArrayList<String> elementi) {
        if (elementi.size() == 1) {
            return new Number(Double.parseDouble(elementi.get(0)));
        }

        if (elementi.contains("+")) {
            int index = elementi.indexOf("+");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Add(algebraic(left), algebraic(right));
        } else if (elementi.contains("-")) {
            int index = elementi.indexOf("-");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Sub(algebraic(left), algebraic(right));
        } else if (elementi.contains("*")) {
            int index = elementi.indexOf("*");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Mul(algebraic(left), algebraic(right));
        } else {
            int index = elementi.indexOf("/");
            ArrayList<String> left = new ArrayList<String>(elementi.subList(0, index));
            ArrayList<String> right = new ArrayList<String>(elementi.subList(index + 1, elementi.size()));
            return new Div(algebraic(left), algebraic(right));
        }
    }
}

