package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Exp <T extends Number<T>> extends AbstractBinaryExpression  <T>{

    public Exp(Expression3 <T> first, Expression3 <T> second) {
        super(first, second);
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        T resFirst = first.evaluate(x, y, z);
        T resSecond = second.evaluate(x, y, z);

        return resFirst.exp(resSecond);
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ")^(" + second.toString() + ")";
    }
}
