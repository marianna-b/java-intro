package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Exp <T extends Number <T> > extends AbstractBinaryExpression {

    public Exp(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public Number evaluate(Number x, Number y, Number z) throws AbstractException {
        Number resFirst = first.evaluate(x, y, z);
        Number resSecond = second.evaluate(x, y, z);

        return (Number)resFirst.exp(resSecond);
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ")^(" + second.toString() + ")";
    }
}
