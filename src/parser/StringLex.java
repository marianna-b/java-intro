package parser;

import java.lang.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class StringLex<T extends Number<T>> extends Lexem <T> {

    public final String name;

    public StringLex(String s) {
        super(LexemType.STRING);

        name = s;
    }

    public String getName() {
        return name;
    }

    @Override
    public LexemType getType() {
        return super.getType();
    }

    @Override
    public String toString() {
        return "Function: " + name;
    }
}
