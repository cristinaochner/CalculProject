package calcolproject.espressione;

public class Add extends Operatore {

    public Add(Espressione e1, Espressione e2) {
        op1 = e1;
        op2 = e2;
    }

    @Override
    public Double execute() {
        return op1.execute() + op2.execute();
    }
}
