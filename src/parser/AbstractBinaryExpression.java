package parser;

public abstract class AbstractBinaryExpression implements Expression3 {

    protected final Expression3 first, second;

    protected AbstractBinaryExpression(Expression3 first, Expression3 second) {
        this.first = first;
        this.second = second;
    }
}
