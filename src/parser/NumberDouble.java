package parser;

import parser.exceptions.AbstractException;
import parser.exceptions.DivisionByZeroException;
import parser.exceptions.InvalidExpException;

import java.lang.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberDouble implements Number<NumberDouble> {

    public double val;
    public NumberDouble(double x) {
        val = x;
    }

    public NumberDouble(String s) {
        val = Double.parseDouble(s);
    }

    public NumberDouble() {
        val = 0;
    }

    public void inc(){
        val++;
    }

    @Override
    public void setMin() {
        val = -100.0;
    }

    @Override
    public boolean isMax() {
        return (int)val == 101;
    }

    @Override
    public NumberDouble sum(NumberDouble b) throws AbstractException {
        return new NumberDouble(val + b.val);
    }

    @Override
    public NumberDouble sub(NumberDouble b) throws AbstractException {
        return new NumberDouble(val - b.val);
    }

    @Override
    public NumberDouble mul(NumberDouble b) throws AbstractException {
        return new NumberDouble(val * b.val);
    }

    @Override
    public NumberDouble div(NumberDouble b) throws AbstractException {
        return new NumberDouble(val / b.val);
    }

    @Override
    public NumberDouble exp(NumberDouble b) throws AbstractException {
        if (b.val < 1e-7 && b.val > -1e-7 && b.val <= 0)
            throw new DivisionByZeroException("division by zero");
        if ((long)b.val < 1e-7)
            throw new InvalidExpException("exp negative number");

        return new NumberDouble(binPow(val, (long)b.val));
    }

    @Override
    public NumberDouble neg() throws AbstractException {
        return new NumberDouble(-val);
    }

    private double binPow(double a, long n) throws AbstractException {
        if (n == 0)
            return 1;

        if (n % 2 == 1) {
            double c = binPow(a, n - 1);
            return c * a;
        } else {
            double b = binPow(a, n / 2);
            return b * b;
        }
    }
}
