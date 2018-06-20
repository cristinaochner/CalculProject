package calcolproject.espressione;

public class Mol extends Operatore {
    public Double execute() {

        return op1.execute() * op2.execute();
    }

    public Mol(Espressione e1, Espressione e2){
        op1=e1;
        op2=e2;
    }
}
