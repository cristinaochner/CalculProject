package com.example.cristina.calcolproject;

public class Mol extends Operatore {
    Double execute() {

        return op1.execute() * op2.execute();
    }

    Mol(Espressione e1, Espressione e2){
        op1=e1;
        op2=e2;
    }
}
