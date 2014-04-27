package parser.expr3;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public abstract class AbstractUnaryExpression <T extends parser.Number<T>> implements Expression3 <T> {
    protected final Expression3 <T> first;

    protected AbstractUnaryExpression(Expression3 <T> first) {
        this.first = first;
    }
}
