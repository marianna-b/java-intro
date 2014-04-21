package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Log <T extends Number <T> > extends AbstractUnaryExpression <T>{
    public Log(Expression3 <T> first) {
        super(first);
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        T resFirst = first.evaluate(x, y, z);
        return resFirst.log();
    }

    @Override
    public String toString() {

        return "lb(" +first.toString() + ")";
    }
}
