package calcolproject.espressione;

import java.util.Stack;

public class ExpressionBuilder {

    Stack<Espressione> s = new Stack<>();

    public ExpressionBuilder n(double d)
    {
        s.push(new Numero(d));
        return this;
    }

    public ExpressionBuilder add()
    {
        s.push(new Add(s.pop(),s.pop()));
        return this;
    }


    public ExpressionBuilder sub()
    {
        //Invert operands
        Espressione e = s.pop();
        s.push(new Add(s.pop(),e));
        return this;
    }


    public ExpressionBuilder mul()
    {
        s.push(new Mol(s.pop(),s.pop()));
        return this;
    }


    public ExpressionBuilder div()
    {
        //Invert operands
        Espressione e = s.pop();
        s.push(new Div(s.pop(),e));
        return this;
    }

    public Espressione pop()
    {
        return s.pop();
    }

}
