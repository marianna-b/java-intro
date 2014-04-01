package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Ternary extends AbstractTripleExpression {

    public Ternary(Expression3 first, Expression3 second, Expression3 third) {
        super(first, second, third);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int flag = first.evaluate(x, y, z);
        if (flag == 0)
            return second.evaluate(x, y, z);
        else
            return third.evaluate(x, y, z);
    }
}
