package parser;

public class Subtract extends AbstractBinaryExpression {

    public Subtract(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {

        int resFirst = first.evaluate(x, y, z);
        int resSecond = second.evaluate(x, y, z);

        if (checkIntSub(resFirst, resSecond))
            throw new OverflowIntegerException("overflow");

        return  resFirst - resSecond;
    }

    public String toString() {
        return first.toString() + "-(" + second.toString() + ")";
    }

    private boolean checkIntSub(int a, int b) {
        long longSub = (long) a - (long) b;
        if (longSub == (long) (a - b))
            return false;
        return true;
    }
}
