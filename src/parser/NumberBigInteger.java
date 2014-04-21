package parser;

import parser.exceptions.AbstractException;

import java.math.BigInteger;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberBigInteger implements Number<NumberBigInteger> {

    BigInteger val;
    public NumberBigInteger(BigInteger a) {
        val = new BigInteger(a.toString());
    }

    public NumberBigInteger(String s) {
        val = new BigInteger(s);
    }

    public void inc(){
        val = val.add(BigInteger.ONE);
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
        return new NumberBigInteger(val.divide(b.val));
    }

    @Override
    public NumberBigInteger exp(NumberBigInteger b) throws AbstractException {
        return new NumberBigInteger(val.modPow(b.val, b.val));

    }

    @Override
    public NumberBigInteger abs() throws AbstractException {
        return new NumberBigInteger(val.abs());
    }

    @Override
    public NumberBigInteger neg() throws AbstractException {
        return new NumberBigInteger(val.negate());
    }

    @Override
    public NumberBigInteger log() throws AbstractException {
        BigInteger curr = BigInteger.valueOf(1);
        BigInteger res = BigInteger.valueOf(0);

        while(true) {
            curr = curr.multiply(BigInteger.valueOf(2));
            if ((curr).compareTo(val) < 1)
                res = res.add(BigInteger.valueOf(1));
            else
                break;
        }

        return new NumberBigInteger(res);
    }


    public NumberBigInteger not() {
        return new NumberBigInteger(val.not());
    }

}
