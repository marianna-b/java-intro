package parser.expr3;

import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Abs <T extends parser.Number <T> > extends AbstractUnaryExpression <T> {

    public Abs(Expression3 <T> first) {
        super(first);
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        return first.evaluate(x, y, x).abs();
    }

    public String toString() {
        return "abs(" + first.toString() + ')';
    }
}