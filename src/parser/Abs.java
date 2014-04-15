package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Abs extends AbstractUnaryExpression {

    public Abs(Expression3 first) {
        super(first);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst = first.evaluate(x, y, z);
        if (checkIntAbs(resFirst))
            throw new OverflowIntegerException("overflow");

        return Math.abs(resFirst);
    }

    public String toString() {
        return "abs(" + first.toString() + ')';
    }

    private boolean checkIntAbs(int a) {
        long longAbs = Math.abs((long) a);
        if (longAbs == (long)Math.abs(a))
            return false;

        return true;
    }
}