package parser.expr3;

import parser.exceptions.AbstractException;

public class Add <T extends parser.Number<T>> extends AbstractBinaryExpression <T> {

    public Add(Expression3 <T> first, Expression3 <T> second) {
        super(first, second);
    }


    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        T resFirst = first.evaluate(x, y, z);
        T resSecond = second.evaluate(x, y, z);

        return resFirst.sum(resSecond);
    }

    @Override
    public String toString() {
        return first + "+" + second;
    }

}
