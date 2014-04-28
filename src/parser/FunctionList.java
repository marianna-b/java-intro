package parser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marianna Bishyarina (bisyarinamariashka@gmail.com)
 */
public abstract class FunctionList<T extends Number<T>> {
    public Map<String, Function<T>> map = new HashMap<>();

    public T invoke(String name, T x) {
        return map.get(name).run(x);
    }

    public interface Function<T> {
        T run(T arg);
    }
}
