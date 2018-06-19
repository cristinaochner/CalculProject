package com.example.cristina.calcolproject;

public class Add extends Operatore {


    @Override
    Double execute() {

        return op1.execute() + op2.execute();
   }

   Add (Espressione e1, Espressione e2){
        op1=e1;
        op2=e2;
   }
}
