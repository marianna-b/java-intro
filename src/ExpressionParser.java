import java.util.List;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser {
    private List <Lexem> lexems;
    private int idx;

    private ExpressionParser(String expression) {
        idx = 0;
        lexems = Lexer.getLexems(expression);
    }

    public static Expression3 parse(String expr) {
        expr = expr.replaceAll("\\s+", "");
        return (new ExpressionParser(expr)).sumLexem();
    }

    private Expression3 sumLexem() {
        Expression3 result;

        if (lexems.get(idx).getType() == Lexem.LexemType.MINUS) {
            idx++;
            result = new Negative(mulLexem());
        } else {
            result = mulLexem();
        }

        while (idx < lexems.size() && (IdxType() == Lexem.LexemType.PLUS || IdxType() == Lexem.LexemType.MINUS)) {
            if (IdxType() == Lexem.LexemType.PLUS) {
                idx++;
                result = new Add(result, mulLexem());
            } else {
                idx++;
                result = new Subtract(result, mulLexem());
            }
        }
        return result;
    }


    private Lexem.LexemType IdxType() {
        return lexems.get(idx).getType();
    }

    private Expression3 mulLexem() {

        Expression3 currMul = lexem();

        while (idx < lexems.size() && (IdxType() == Lexem.LexemType.MUL || IdxType() == Lexem.LexemType.DIV)) {

            if (IdxType() == Lexem.LexemType.MUL) {
                idx++;
                currMul = new Multiply(currMul, lexem());
            } else {
                idx++;
                currMul = new Divide(currMul, lexem());
            }
        }
        return currMul;
    }

    private Expression3 lexem() {

        Expression3 result;

        if (IdxType() == Lexem.LexemType.CONST) {
            result = new Const(((NumLex)lexems.get(idx)).getValue());
            idx++;
        } else if (IdxType() == Lexem.LexemType.VAR) {
            result = new Variable(((VarLex)lexems.get(idx)).getName());
            idx++;
        } else if (IdxType() == Lexem.LexemType.MINUS) {
            idx++;
            result = new Negative(lexem());
        } else if (IdxType() == Lexem.LexemType.OPEN_BRACKET) {
            idx++;
            result = sumLexem();
            idx++;
        } else {
            throw new RuntimeException("");
        }
        return result;
    }
}
