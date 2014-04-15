package parser;

import java.util.List;

import static parser.Lexem.LexemType.CLOSE_BRACKET;


/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser {
    private List<Lexem> lexems;
    private int idx;

    private ExpressionParser(String expression) throws ParseExpressionException {
        idx = 0;
        lexems = Lexer.getLexems(expression);
    }

    public static Expression3 parse(String expr) throws ParseExpressionException {

        ExpressionParser parser = new ExpressionParser(expr);
        Expression3 result = (parser).evalLexem(1);
        if (parser.idx < parser.lexems.size())
            throw new ParseExpressionException("invalid end of expression");
        return result;
    }


    private Expression3 evalLexem(int priority) throws ParseExpressionException {
        if (priority > 4) {
            return lexem();
        }

        if (priority == 3)
            return evalExp();

        Expression3 result;
        result = evalLexem(priority + 1);

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(priority))) {
            Lexem prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalLexem(priority + 1));
        }
        return result;
    }

    private Expression3 evalExp() throws ParseExpressionException {
        Expression3 result = lexem();

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(3))) {
            Lexem prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalExp());
        }
        return result;
    }

    private Lexem.LexemType idxType() {
        return lexems.get(idx).getType();
    }

    private Expression3 lexem() throws ParseExpressionException {

        Expression3 result;
        if (idx >= lexems.size())
            throw new ParseExpressionException("unexpected end of expression");
        Lexem.LexemType lexemType = lexems.get(idx).type;

        switch (lexemType) {
            case LOG:
                idx++;
                result = new Log(lexem());
                break;

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
                result = evalLexem(1);
                lexemType = lexems.get(idx).type;
                if (lexemType == CLOSE_BRACKET)
                    idx++;
                else
                    throw new InvalidLexemException(lexems.get(idx));

                break;

            default:
                throw new InvalidLexemException(lexems.get(idx));

        }
        return result;
    }
}
