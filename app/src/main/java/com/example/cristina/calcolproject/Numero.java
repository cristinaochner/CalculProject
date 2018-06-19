package com.example.cristina.calcolproject;

public class Numero extends Espressione {
    Double value;

    @Override
    Double execute() {
        return value;
    }

    Numero(Double n){
        value=n;
    }

}
