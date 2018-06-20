package calcolproject.espressione;

public class Add extends Operatore {


    @Override
    public Double execute() {

        return op1.execute() + op2.execute();
   }

    public Add (Espressione e1, Espressione e2){
        op1=e1;
        op2=e2;
   }
}
