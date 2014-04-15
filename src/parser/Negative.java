package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Negative extends AbstractUnaryExpression {

    public Negative(Expression3 first) {
        super(first);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst = first.evaluate(x, y, z);
        if (checkIntNegate(resFirst))
            throw new OverflowIntegerException("overflow");
        return - resFirst;
    }

    public String toString() {

        return "-(" + first.toString() + ")";
    }

    private boolean checkIntNegate(int a) {
        long longNeg = - (long) a;
        if (longNeg == (long) (-a))
            return false;
        return true;
    }
}
