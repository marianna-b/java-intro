package parser;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Settings {
    public static Map<String, FunctionList.Function<Integer>> functionsInteger = new HashMap<>();
    public static Map<String, FunctionList.Function<Double>> functionsDouble = new HashMap<>();
    public static Map<String, FunctionList.Function<BigInteger>> functionsBigInteger = new HashMap<>();

    static {
        functionsInteger.put("abs", new FunctionList.Function<Integer>() {
            @Override
            public Integer run(Integer arg) {
                return Math.abs(arg);
            }
        });

        functionsDouble.put("abs", new FunctionList.Function<Double>() {
            @Override
            public Double run(Double arg) {
                return Math.abs(arg);
            }
        });


        functionsBigInteger.put("abs", new FunctionList.Function<BigInteger>() {
            @Override
            public BigInteger run(BigInteger arg) {
                return arg.abs();
            }
        });
    }
}
