public class Multiply extends AbstractBinaryExpression {

    public Multiply(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public int evaluate(int value) {
        return first.evaluate(value) * second.evaluate(value);
    }
}
