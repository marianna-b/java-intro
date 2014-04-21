package parser.expr3;

public abstract class AbstractBinaryExpression <T extends parser.Number <T>> implements Expression3 <T> {

    protected final Expression3 <T> first, second;

    protected AbstractBinaryExpression(Expression3 <T> first, Expression3 <T> second) {
        this.first = first;
        this.second = second;
    }
}
