public abstract class AbstractBinaryExpression implements Expression {

    protected final Expression first, second;

    protected AbstractBinaryExpression(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }
}
