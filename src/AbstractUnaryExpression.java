/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public abstract class AbstractUnaryExpression implements Expression3 {
    protected final Expression3 first;

    protected AbstractUnaryExpression(Expression3 first) {
        this.first = first;
    }
}
