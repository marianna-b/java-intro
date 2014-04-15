package parser;

public class Add extends AbstractBinaryExpression {

    public Add(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst, resSecond;

        resFirst = first.evaluate(x, y, z);
        resSecond = second.evaluate(x, y, z);

        if (checkAddInt(resFirst, resSecond))
            throw new OverflowIntegerException("overflow");
        return resFirst + resSecond;
    }

    private boolean checkAddInt(Integer a, Integer b) {
        long longSum = (long)a + (long)b;
        Integer intSum = a + b;

        if ((long)intSum == longSum)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return first + "+" + second;
    }

}
