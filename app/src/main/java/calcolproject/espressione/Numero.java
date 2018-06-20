package calcolproject.espressione;

import calcolproject.espressione.Espressione;

public class Numero extends Espressione {
    Double value;

    @Override
    public Double execute() {
        return value;
    }

    public Numero(Double n){
        value=n;
    }

}
