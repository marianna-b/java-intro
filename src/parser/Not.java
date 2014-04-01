package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Not extends AbstractUnaryExpression {

    public Not(Expression3 first) {
        super(first);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return ~ first.evaluate(x, y, z);
    }
}