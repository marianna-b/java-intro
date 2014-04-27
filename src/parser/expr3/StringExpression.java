package parser.expr3;

import parser.FunctionList;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class StringExpression<T extends parser.Number<T>> extends AbstractUnaryExpression <T> {

    String name;
    FunctionList functions;

    public StringExpression(String name, Expression3<T> first, FunctionList f) {
        super(first);
        this.name = name;
        this.functions = f;
    }



    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
         T res = first.evaluate(x, y, z);
        return (T) functions.map.get(name).run(res);
    }
}
