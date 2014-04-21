package parser.expr3;

import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Negative <T extends parser.Number<T>> extends AbstractUnaryExpression <T> {

    public Negative(Expression3 <T> first) {
        super(first);
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        T resFirst = first.evaluate(x, y, z);
        return resFirst.neg();
    }

    public String toString() {

        return "-(" + first.toString() + ")";
    }
}
