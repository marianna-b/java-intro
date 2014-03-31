/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public abstract class AbstractTripleExpression implements Expression3 {
    protected final Expression3 first, second, third;

    protected AbstractTripleExpression(Expression3 first, Expression3 second, Expression3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
