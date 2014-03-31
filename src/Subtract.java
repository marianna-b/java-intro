public class Subtract extends AbstractBinaryExpression {

    public Subtract(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return first.evaluate(x, y, z) - second.evaluate(x, y, z);
    }
}
