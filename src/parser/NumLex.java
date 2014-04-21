package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class NumLex <T extends Number <T>> extends Lexem <T>{
    public final T value;

    public NumLex(T num) {
        super(LexemType.CONST);

        value = num;
    }

    public T getValue() {
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
