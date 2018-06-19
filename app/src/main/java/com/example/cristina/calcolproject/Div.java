package com.example.cristina.calcolproject;

public class Div extends Operatore {
    Double execute() {
        return op1.execute()/op2.execute();
    }

    Div (Espressione e1, Espressione e2){
        op1=e1;
        op2=e2;
    }
}
