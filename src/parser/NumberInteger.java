package parser;

import parser.exceptions.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
    public class NumberInteger implements Number<NumberInteger> {

    int val;

    public NumberInteger(int x) {
        val = x;
    }

    public void inc(){
        val++;
    }

    public NumberInteger(String s) {
        val = Integer.parseInt(s);
    }

    @Override
    public NumberInteger sum(NumberInteger b) throws AbstractException {
        if (checkIntAdd(val, b.val))
            throw new OverflowIntegerException("overflow");
        return new NumberInteger(val + b.val);
    }

    @Override
    public NumberInteger sub(NumberInteger b) throws AbstractException {
        if (checkIntSub(val, b.val))
            throw new OverflowIntegerException("overflow");
        return new NumberInteger(val - b.val);
    }

    @Override
    public NumberInteger mul(NumberInteger b) throws AbstractException {
        if (checkIntMul(val, b.val))
            throw new OverflowIntegerException("overflow");
        return new NumberInteger(val * b.val);
    }

    @Override
    public NumberInteger div(NumberInteger b) throws AbstractException {
        if (b.val == 0)
            throw new DivisionByZeroException("division by zero");

        if (checkIntAdd(val, b.val))
            throw new OverflowIntegerException("overflow");

        return new NumberInteger(val / b.val);
    }


    public NumberInteger exp(NumberInteger b) throws AbstractException{
        if (val == 0 && b.val <= 0)
            throw new DivisionByZeroException("division by zero");
        if (b.val < 0)
            throw new InvalidExpException("exp negative number");

        return new NumberInteger(binPow(val, b.val));
    }


    public NumberInteger abs() throws AbstractException{
        if (checkIntAbs(val))
            throw new OverflowIntegerException("overflow");

        return new NumberInteger(Math.abs(val));
    }

    @Override
    public NumberInteger neg() throws AbstractException {
        if (checkIntNegate(val))
            throw new OverflowIntegerException("overflow");
        return new NumberInteger(-val);
    }


    public NumberInteger log() throws AbstractException {
        if (val < 0)
            throw new InvalidLogException("log is under zero");
        if (checkIntLog(val))
            throw new OverflowIntegerException("overflow");

        return  new NumberInteger((int)(Math.log((double)val) / Math.log(2)));
    }

    public NumberInteger not() {
        return new NumberInteger(~val);
    }

    private Integer binPow(Integer a, Integer n) throws AbstractException {
        if (n == 0)
            return 1;

        if (n % 2 == 1) {
            Integer c = binPow(a, n - 1);

            if (checkIntMul(c, a))
                throw new OverflowIntegerException("overflow");

            return c * a;
        } else {
            Integer b = binPow(a, n / 2);

            if (checkIntMul(b, b))
                throw new OverflowIntegerException("overflow");

            return b * b;
        }
    }

    private boolean checkIntMul(Integer a, Integer b) {
        long longMul = (long) a * (long) b;

        if (longMul == (long) (a * b))
            return false;
        return true;
    }

    private boolean checkIntAdd(Integer a, Integer b) {
        long longSum = (long) a + (long) b;
        Integer intSum = a + b;

        if ((long)intSum == longSum)
            return false;

        return true;
    }

    private boolean checkIntAbs(int a) {
        long longAbs = Math.abs((long) a);
        if (longAbs == (long)Math.abs(a))
            return false;

        return true;
    }

    private boolean checkIntSub(int a, int b) {
        long longSub = (long) a - (long) b;
        if (longSub == (long) (a - b))
            return false;
        return true;
    }

    private boolean checkIntNegate(int a) {
        long longNeg = - (long) a;
        if (longNeg == (long) (-a))
            return false;
        return true;
    }

    private boolean checkIntLog(int a) {
        long longLog = (long)(Math.log((double)a) / Math.log(2));
        int intLog = (int)(Math.log((double)a) / Math.log(2));

        if (longLog == (long)intLog)
            return false;
        return true;
    }
}
