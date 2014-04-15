package parser;

public class Multiply extends AbstractBinaryExpression {

    public Multiply(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst = first.evaluate(x, y, z);
        int resSecond = second.evaluate(x, y, z);

        if (checkIntMul(resFirst, resSecond))
            throw new OverflowIntegerException("overflow");

        return  resFirst * resSecond;
    }

    public String toString() {

        return "(" + first + ")*(" + second + ")";
    }

    private boolean checkIntMul(int a, int b) {
        long longMul = (long) a * (long) b;

        if (longMul == (long) (a * b))
            return false;
        return true;
    }

}
