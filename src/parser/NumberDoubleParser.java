package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumberDoubleParser implements NumberParser <NumberDouble> {
    @Override
    public NumberDouble parseNumber(String s) {
        return new NumberDouble(Double.parseDouble(s));
    }
}
