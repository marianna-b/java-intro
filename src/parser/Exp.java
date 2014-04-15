package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Exp extends AbstractBinaryExpression {

    public Exp(Expression3 first, Expression3 second) {
        super(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst = first.evaluate(x, y, z);
        int resSecond = second.evaluate(x, y, z);

        if (resFirst == 0 && resSecond <= 0)
            throw new DivisionByZeroException("division by zero");
        if (resSecond < 0)
            throw new InvalidExpException("exp negative number");
        return binPow(resFirst, resSecond);
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ")^(" + second.toString() + ")";
    }

    private int binPow(int a, int n) throws AbstractException {
        if (n == 0)
            return 1;
        if (n % 2 == 1) {
            int c = binPow(a, n - 1);
            if (checkIntMul(c, a))
                throw new OverflowIntegerException("overflow");
            return c * a;
        } else {
            int b = binPow(a, n / 2);
            if (checkIntMul(b, b))
                throw new OverflowIntegerException("overflow");
            return b * b;
        }
    }

    private boolean checkIntMul(int a, int b) {
        long longMul = (long) a * (long) b;

        if (longMul == (long) (a * b))
            return false;
        return true;
    }
}
