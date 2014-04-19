package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Log <T extends Number<T> > extends AbstractUnaryExpression {
    public Log(Expression3 first) {
        super(first);
    }

    @Override
    public Number evaluate(Number x, Number y, Number z) throws AbstractException {
        Number resFirst = first.evaluate(x, y, z);

        return (Number) resFirst.log();
    }

    @Override
    public String toString() {

        return "lb(" +first.toString() + ")";
    }
}
