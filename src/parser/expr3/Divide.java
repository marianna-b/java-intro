package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

public class Divide <T extends Number<T>> extends AbstractBinaryExpression <T> {

    public Divide(Expression3 <T> first, Expression3 <T> second) {
        super(first, second);
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        T resFirst = first.evaluate(x, y, z);
        T resSecond = second.evaluate(x, y, z);

        return resFirst.div(resSecond);
    }

    public String toString() {

        return "(" + first + ")/(" + second + ")";
    }
}
