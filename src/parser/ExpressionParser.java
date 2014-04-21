package parser;

import parser.exceptions.InvalidLexemException;
import parser.exceptions.ParseExpressionException;
import parser.expr3.*;

import java.util.List;

import static parser.Lexem.LexemType.CLOSE_BRACKET;


/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser <T extends Number <T>> {
    private List<Lexem <T>> lexems;
    private int idx;

    public ExpressionParser(String expression, NumberParser<T> a) throws ParseExpressionException {
        idx = 0;
        Lexer <T> curr = new Lexer<>(expression, a);
        lexems = curr.getLexems();
    }

    public Expression3<T> parse() throws ParseExpressionException {
        Expression3 <T> result = evalLexem(1);
        if (idx < lexems.size())
            throw new ParseExpressionException("invalid end of expression");
        return result;
    }


    private Expression3 <T> evalLexem(int priority) throws ParseExpressionException {
        if (priority > 4) {
            return lexem();
        }

        if (priority == 3)
            return evalExp();

        Expression3<T> result;
        result = evalLexem(priority + 1);

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(priority))) {
            Lexem<T> prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalLexem(priority + 1));
        }
        return result;
    }

    private Expression3 <T> evalExp() throws ParseExpressionException {
        Expression3 <T> result = lexem();

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(3))) {
            Lexem<T> prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalExp());
        }
        return result;
    }

    private Expression3<T> lexem() throws ParseExpressionException {

        Expression3<T> result;
        if (idx >= lexems.size())
            throw new ParseExpressionException("unexpected end of expression");
        Lexem.LexemType lexemType = lexems.get(idx).type;

        switch (lexemType) {
            case LOG:
                idx++;
                result = new Log<>(lexem());
                break;

            case CONST:
                result = new Const<>(((NumLex<T>) lexems.get(idx)).getValue());
                idx++;
                break;

            case VAR:
                result = new Variable<>(((VarLex) lexems.get(idx)).getName());
                idx++;
                break;

            case MINUS:
                idx++;
                result = new Negative<>(lexem());
                break;

            case ABS:
                idx++;
                result = new Abs<>(lexem());
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
