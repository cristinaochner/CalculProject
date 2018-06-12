package com.example.cristina.calcolproject;

public class Number extends Expression {
    Double number;

    @Override
    Double execute() {
        return number;
    }

    Number(Double n){

        number=n;
    }



}
