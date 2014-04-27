package parser;

import parser.exceptions.AbstractException;
import parser.exceptions.DivisionByZeroException;
import parser.exceptions.InvalidExpException;
import parser.exceptions.InvalidLogException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
    public class NumberInteger implements parser.Number<NumberInteger> {

    public int val;

    public NumberInteger(int x) {
        val = x;
    }

    public NumberInteger() {
        val = 0;
    }

    public void inc(){
        val++;
    }

    @Override
    public void setMin() {
        val = -100;
    }

    @Override
    public boolean isMax() {
        return val == 101;
    }

    public NumberInteger(String s) {
        val = Integer.parseInt(s);
    }

    @Override
    public NumberInteger sum(NumberInteger b) {
        return new NumberInteger(val + b.val);
    }

    @Override
    public NumberInteger sub(NumberInteger b) throws AbstractException {
        return new NumberInteger(val - b.val);
    }

    @Override
    public NumberInteger mul(NumberInteger b) throws AbstractException {
        return new NumberInteger(val * b.val);
    }

    @Override
    public NumberInteger div(NumberInteger b) throws AbstractException {
        if (b.val == 0)
            throw new DivisionByZeroException("division by zero");

        return new NumberInteger(val / b.val);
    }


    public NumberInteger exp(NumberInteger b) throws AbstractException {
        if (val == 0 && b.val <= 0)
            throw new DivisionByZeroException("division by zero");
        if (b.val < 0)
            throw new InvalidExpException("exp negative number");

        return new NumberInteger(binPow(val, b.val));
    }


    public NumberInteger abs() throws AbstractException {
        return new NumberInteger(Math.abs(val));
    }

    @Override
    public NumberInteger neg() throws AbstractException {
        return new NumberInteger(-val);
    }


    public NumberInteger log() throws AbstractException {
        if (val < 0)
            throw new InvalidLogException("log is under zero");

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

            return c * a;
        } else {
            Integer b = binPow(a, n / 2);

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
