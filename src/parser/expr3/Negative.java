package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Negative <T extends parser.Number<T>> extends AbstractUnaryExpression {

    public Negative(Expression3 first) {
        super(first);
    }

    @Override
    public Number evaluate(Number x, Number y, Number z) throws AbstractException {
        Number resFirst = first.evaluate(x, y, z);
        return (Number)resFirst.neg();
    }

    public String toString() {

        return "-(" + first.toString() + ")";
    }
}
