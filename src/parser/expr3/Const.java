package parser.expr3;

import parser.Number;

public class Const <T extends parser.Number <T> > implements Expression3 {

    private final T value;

    public Const(T value) {
        this.value = value;
    }

    @Override
    public Number evaluate (Number x, Number y, Number z) {
        return this.value;
    }

}
