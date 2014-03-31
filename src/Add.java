public class Add extends AbstractBinaryExpression {

    public Add(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public double evaluate(double x, double y, double z) {
        return first.evaluate(x, y, z) + second.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        return first + "+" + second;
    }
}
