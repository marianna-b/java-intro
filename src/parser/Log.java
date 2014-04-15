package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Log extends AbstractUnaryExpression {
    public Log(Expression3 first) {
        super(first);
    }

    @Override
    public int evaluate(int x, int y, int z) throws AbstractException {
        int resFirst = first.evaluate(x, y, z);

        if (resFirst < 0)
            throw new InvalidLogException("log is under zero");
        if (checkIntLog(resFirst))
            throw new OverflowIntegerException("overflow");
        return (int) (Math.log((double)resFirst) / Math.log(2));
    }

    @Override
    public String toString() {

        return "lb(" +first.toString() + ")";
    }

    private boolean checkIntLog(int a) {
        long longLog = (long)Math.log((double) a);
        int intLog = (int)Math.log((double) a);
        if (longLog == (long)intLog)
            return false;
        return true;
    }
}
