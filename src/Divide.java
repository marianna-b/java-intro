public class Divide extends AbstractBinaryExpression {

    public Divide(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public int evaluate(int value) {
        return first.evaluate(value) / second.evaluate(value);
    }
}
