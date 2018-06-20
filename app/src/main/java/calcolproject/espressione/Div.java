package calcolproject.espressione;

public class Div extends Operatore {
    public Double execute() {
        return op1.execute()/op2.execute();
    }

    public Div (Espressione e1, Espressione e2){
        op1=e1;
        op2=e2;
    }
}
