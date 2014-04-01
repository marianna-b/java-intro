package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Negative extends AbstractUnaryExpression {

    public Negative(Expression3 first) {
        super(first);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return - first.evaluate(x, y, z);
    }
}
