/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Negative extends AbstractUnaryExpression {

    public Negative(Expression3 first) {
        super(first);
    }

    @Override
    public double evaluate(double x, double y, double z) {
        return - first.evaluate(x, y, z);
    }
}
