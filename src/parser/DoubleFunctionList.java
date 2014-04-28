package parser;

import java.util.Map;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class DoubleFunctionList extends FunctionList<NumberDouble> {
    public DoubleFunctionList() {
        for (final Map.Entry<String, Function<Double>> entry: Settings.functionsDouble.entrySet()) {
            map.put(entry.getKey(), new Function<NumberDouble>() {
                @Override
                public NumberDouble run(NumberDouble arg) {
                    return new NumberDouble(entry.getValue().run(arg.val));
                }
            });
        }
    }
}
