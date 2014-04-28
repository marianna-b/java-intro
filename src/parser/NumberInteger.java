package parser;

import parser.exceptions.AbstractException;
import parser.exceptions.DivisionByZeroException;
import parser.exceptions.InvalidExpException;

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

    public NumberInteger(String s) {
        val = Integer.parseInt(s);
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


    @Override
    public NumberInteger neg() throws AbstractException {
        return new NumberInteger(-val);
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
}
