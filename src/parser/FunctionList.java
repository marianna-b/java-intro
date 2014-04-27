package parser;

import java.util.Map;
import java.util.TreeMap;


/**
 * @author Marianna Bishyarina (bisyarinamariashka@gmail.com)
 */
public class FunctionList {
    public Map<String, Function> map = new TreeMap<>();

    public FunctionList(NumberInteger a) {
        map.put("abs", new Function() {
            @Override
            public Number run(Number arg) {
                NumberInteger x = (NumberInteger)arg;
                return new NumberInteger(Math.abs(x.val));
            }
        });
    }

    public FunctionList(NumberDouble a) {
        map.put("abs", new Function() {
            @Override
            public Number run(Number arg) {
                NumberDouble x = (NumberDouble)arg;
                return new NumberDouble(Math.abs(x.val));
            }
        });
    }

    public FunctionList(NumberBigInteger a) {
        map.put("abs", new Function() {
            @Override
            public Number run(Number arg) {
                NumberBigInteger x = (NumberBigInteger)arg;
                return new NumberBigInteger(x.val.abs());
            }
        });
    }

    public interface Function<T extends Number<T>> {
        T run(T arg);
    }
}
