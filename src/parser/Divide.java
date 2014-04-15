package parser;

public class Divide extends AbstractBinaryExpression {

    public Divide(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst = first.evaluate(x, y, z);
        int resSecond = second.evaluate(x, y, z);

        if (resSecond == 0)
            throw new DivisionByZeroException("division by zero");

        if (checkIntDiv(resFirst, resSecond))
            throw new OverflowIntegerException("overflow");

        return first.evaluate(x, y, z) / second.evaluate(x, y, z);
    }

    public String toString() {

        return "(" + first + ")/(" + second + ")";
    }

    private boolean checkIntDiv(int a, int b) {
        long longDiv = (long) a / (long) b;
        if (longDiv == (long) (a / b))
            return false;
        return true;
    }

}
