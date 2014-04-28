package parser.expr3;

import parser.FunctionList;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class FunctionExpr<T extends parser.Number<T>> extends AbstractUnaryExpression <T> {

    String name;
    FunctionList <T> functions;

    public FunctionExpr(String a, Expression3<T> first, FunctionList<T> f) {
        super(first);
        this.name = a;
        this.functions = f;
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        return functions.invoke(name, first.evaluate(x, y, z));
    }
}
