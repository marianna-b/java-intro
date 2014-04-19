package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumLex <T extends Number <T>> extends Lexem {
    public final Number value;

    public NumLex(Number num) {
        super(LexemType.CONST);

        value = num;
    }

    public Number getValue() {
        return value;
    }

    @Override
    public LexemType getType() {
        return super.getType();
    }

    @Override
    public String toString() {
        return "Number";
    }
}
