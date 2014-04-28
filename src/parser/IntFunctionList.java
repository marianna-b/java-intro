package parser;

import java.util.Map;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class IntFunctionList extends FunctionList<NumberInteger> {
    public IntFunctionList() {
        for (final Map.Entry<String, Function<Integer>> entry: Settings.functionsInteger.entrySet()) {
            map.put(entry.getKey(), new Function<NumberInteger>() {
                @Override
                public NumberInteger run(NumberInteger arg) {
                    return new NumberInteger(entry.getValue().run(arg.val));
                }
            });
        }
    }
}
