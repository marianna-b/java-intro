package parser;

import java.util.List;

import static parser.Lexem.LexemType.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser {
    private List<Lexem> lexems;
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
        result = mulLexem();

        while (idx < lexems.size() && (idxType() == PLUS || idxType() == MINUS)) {
            if (idxType() == PLUS) {
                idx++;
                result = new Add(result, mulLexem());
            } else {
                idx++;
                result = new Subtract(result, mulLexem());
            }
        }
        return result;
    }


    private Lexem.LexemType idxType() {
        return lexems.get(idx).getType();
    }

    private Expression3 mulLexem() {

        Expression3 currMul;
        currMul = lexem();

        while (idx < lexems.size() && (idxType() == MUL || idxType() == DIV)) {

            if (idxType() == MUL) {
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

        Lexem.LexemType lexemType = idxType();
        switch (lexemType) {
            case CONST:
                result = new Const(((NumLex) lexems.get(idx)).getValue());
                idx++;
                break;
            case VAR:
                result = new Variable(((VarLex) lexems.get(idx)).getName());
                idx++;
                break;
            case MINUS:
                idx++;
                result = new Negative(lexem());
                break;
            case ABS:
                idx++;
                result = new Abs(lexem());
                break;
            case NOT:
                idx++;
                result = new Not(lexem());
                break;
            case OPEN_BRACKET:
                idx++;
                result = sumLexem();
                idx++;
                break;
            default:
                throw new RuntimeException("");
        }
        return result;
    }
}
