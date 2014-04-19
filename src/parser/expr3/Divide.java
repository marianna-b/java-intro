package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

public class Divide extends AbstractBinaryExpression {

    public Divide(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public Number evaluate(Number x, Number y, Number z) throws AbstractException {
        Number resFirst = first.evaluate(x, y, z);
        Number resSecond = second.evaluate(x, y, z);

        return (Number)resFirst.div(resSecond);
    }

    public String toString() {

        return "(" + first + ")/(" + second + ")";
    }
}
