package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberIntegerParser implements NumberParser<NumberInteger> {
    @Override
    public NumberInteger parseNumber(String s) {
        return new NumberInteger(Integer.parseInt(s));
    }
}
