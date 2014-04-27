package parser;

import java.lang.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public interface NumberParser <T extends Number<T>> {
    T parseNumber(String s);
}
