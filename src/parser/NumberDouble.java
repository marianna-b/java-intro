package parser;

import parser.exceptions.AbstractException;
import parser.exceptions.DivisionByZeroException;
import parser.exceptions.InvalidExpException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberDouble implements Number<NumberDouble> {

    double val;
    public NumberDouble(double x) {
        val = x;
    }

    public NumberDouble(String s) {
        val = Double.parseDouble(s);
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
        if (Double.compare(b.val, 0.0) == 0)
            throw new DivisionByZeroException("division by zero");
        return new NumberDouble(val / b.val);
    }

    @Override
    public NumberDouble exp(NumberDouble b) throws AbstractException {
        if (Double.compare(val, 0.0) == 1 && b.val <= 0)
            throw new DivisionByZeroException("division by zero");
        if ((long)b.val < 0)
            throw new InvalidExpException("exp negative number");

        return new NumberDouble(binPow(val, (long)b.val));
    }

    @Override
    public NumberDouble abs() throws AbstractException {
        return new NumberDouble(Math.abs(val));
    }

    @Override
    public NumberDouble neg() throws AbstractException {
        return new NumberDouble(-val);
    }

    @Override
    public NumberDouble log() throws AbstractException {
        return new NumberDouble (Math.log(val) / Math.log(2));
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
