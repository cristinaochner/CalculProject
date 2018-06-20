package calcolproject.espressione;

public class Numero extends Espressione {
    Double value;

    public Numero(Double n) {
        value = n;
    }

    @Override
    public Double execute() {
        return value;
    }

}
