package parser;

import java.math.BigInteger;
import java.util.Map;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class BigIntFunctionList extends FunctionList<NumberBigInteger> {
    public BigIntFunctionList() {
        for (final Map.Entry<String, Function<BigInteger>> entry: Settings.functionsBigInteger.entrySet()) {
            map.put(entry.getKey(), new Function<NumberBigInteger>() {
                @Override
                public NumberBigInteger run(NumberBigInteger arg) {
                    return new NumberBigInteger(entry.getValue().run(arg.val));
                }
            });
        }
    }
}
