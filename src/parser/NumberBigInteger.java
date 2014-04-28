package parser;

import parser.exceptions.AbstractException;
import parser.exceptions.DivisionByZeroException;

import java.lang.*;
import java.math.BigInteger;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberBigInteger implements parser.Number<NumberBigInteger> {

    public BigInteger val;
    public NumberBigInteger(BigInteger a) {
        val = new BigInteger(a.toString());
    }

    public NumberBigInteger() {
        val = BigInteger.ZERO;
    }

    public NumberBigInteger(String s) {
        val = new BigInteger(s);
    }

    public void inc(){
        val = val.add(BigInteger.ONE);
    }

    @Override
    public void setMin() {
        val = BigInteger.TEN.multiply(BigInteger.TEN).negate();
    }

    @Override
    public boolean isMax() {
        return val.compareTo(BigInteger.TEN.multiply(BigInteger.TEN).add(BigInteger.ONE)) == 0;
    }

    @Override
    public NumberBigInteger sum(NumberBigInteger b) throws AbstractException {
        return new NumberBigInteger(val.add(b.val));
    }

    @Override
    public NumberBigInteger sub(NumberBigInteger b) throws AbstractException {
        return new NumberBigInteger(val.subtract(b.val));
    }

    @Override
    public NumberBigInteger mul(NumberBigInteger b) throws AbstractException {
        return new NumberBigInteger(val.multiply(b.val));
    }

    @Override
    public NumberBigInteger div(NumberBigInteger b) throws AbstractException {
        if (b.val.equals(BigInteger.ZERO))
            throw new DivisionByZeroException("division by zero");
        return new NumberBigInteger(val.divide(b.val));
    }

    @Override
    public NumberBigInteger exp(NumberBigInteger b) throws AbstractException {
        return new NumberBigInteger(val.modPow(b.val, b.val));

    }

    @Override
    public NumberBigInteger neg() throws AbstractException {
        return new NumberBigInteger(val.negate());
    }


    public NumberBigInteger not() {
        return new NumberBigInteger(val.not());
    }

}
