package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Abs extends AbstractUnaryExpression {

    public Abs(Expression3 first) {
        super(first);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Math.abs(first.evaluate(x, y, z));
    }
}