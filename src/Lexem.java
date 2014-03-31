/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Lexem {
    protected final LexemType type;

    public Lexem(LexemType type) {
        this.type = type;
    }

    public static enum LexemType{
        CONST,
        VAR,
        PLUS,
        MINUS,
        MUL,
        DIV,
        OPEN_BRACKET,
        CLOSE_BRACKET
    }

    public LexemType getType() {
        return type;
    }
}
