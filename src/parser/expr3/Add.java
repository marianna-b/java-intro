package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

public class Add <T extends parser.Number<T> > extends AbstractBinaryExpression {

    public Add(Expression3 first, Expression3 second) {
        super(first, second);
    }


    @Override
    public Number evaluate(Number x, Number y, Number z) throws AbstractException {
        Number resFirst = first.evaluate(x, y, z);
        Number resSecond = second.evaluate(x, y, z);

        return (Number)resFirst.sum(resSecond);
    }

    @Override
    public String toString() {
        return first + "+" + second;
    }

}
