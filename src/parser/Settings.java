package parser;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static parser.FunctionList.Function;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Settings {
    public static Map<String, Function<Integer>> functionsInteger = new HashMap<>();
    public static Map<String, Function<Double>> functionsDouble = new HashMap<>();
    public static Map<String, Function<BigInteger>> functionsBigInteger = new HashMap<>();

    static {
        new Abs().put();
    }

    static class Abs implements AllTypeFunctions {

        public void put() {
            Abs abs = new Abs();
            abs.putInteger();
            abs.putDouble();
            abs.putBigInteger();
        }

        public void putInteger() {

            functionsInteger.put("abs", new Function<Integer>() {
                @Override
                public Integer run(Integer arg) {
                    return Math.abs(arg);
                }
            });
        }

        public void putDouble() {
            functionsDouble.put("abs", new Function<Double>() {
                @Override
                public Double run(Double arg) {
                    return Math.abs(arg);
                }
            });
        }

        public void putBigInteger() {
            functionsBigInteger.put("abs", new Function<BigInteger>() {
                @Override
                public BigInteger run(BigInteger arg) {
                    return arg.abs();
                }
            });
        }
    }

    static interface AllTypeFunctions {
        void put();

        void putInteger();
        void putDouble();
        void putBigInteger();
    }
}
