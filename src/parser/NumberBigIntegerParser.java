package parser;

import java.math.BigInteger;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberBigIntegerParser implements NumberParser <NumberBigInteger> {
    @Override
    public NumberBigInteger parseNumber(String s) {
        BigInteger num = new BigInteger(s);
        return new NumberBigInteger(num);
    }
}
