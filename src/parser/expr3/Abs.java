package parser.expr3;

import parser.Number;
import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Abs <T extends parser.Number <T> > extends AbstractUnaryExpression {

    public Abs(Expression3 first) {
        super(first);
    }
   
    @Override
    public Number evaluate(Number x, Number y, Number z) throws AbstractException {
        return (Number)first.evaluate(x, y, x).abs();
    }

    public String toString() {
        return "abs(" + first.toString() + ')';
    }
}