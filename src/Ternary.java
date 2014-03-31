/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Ternary extends AbstractTripleExpression {

    private static final double EPS = 1e-9;

    public Ternary(Expression3 first, Expression3 second, Expression3 third) {
        super(first, second, third);
    }

    @Override
    public double evaluate(double x, double y, double z) {
        double flag = first.evaluate(x, y, z);
        if (flag < EPS && flag > - EPS)
            return second.evaluate(x, y, z);
        else
            return third.evaluate(x, y, z);
    }
}
