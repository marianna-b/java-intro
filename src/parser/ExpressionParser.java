package parser;

import parser.expr3.*;

import java.util.List;


/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser <T extends Number<T>> {
    private List<Lexem <T>> lexems;
    private int idx;
    private FunctionList<T> functions;

    public ExpressionParser(String expression, NumberParser<T> a, FunctionList <T> f) {
        idx = 0;
        Lexer <T> curr = new Lexer<>(expression, a);
        lexems = curr.getLexems();
        functions = f;
    }


    public Expression3<T> parse() {
        return evalLexem(1);
    }


    private Expression3 <T> evalLexem(int priority){
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

    private Expression3 <T> evalExp() {
        Expression3 <T> result = lexem();

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(3))) {
            Lexem<T> prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalExp());
        }
        return result;
    }

    private Expression3<T> lexem() {

        Expression3<T> result;
        Lexem.LexemType lexemType = lexems.get(idx).type;
        String s;

        switch (lexemType) {
            case CONST:
                result = new Const<>(((NumLex<T>) lexems.get(idx)).getValue());
                idx++;
                break;

            case STRING:
                s = ((StringLex) lexems.get(idx)).getName();
                idx++;
                result = new FunctionExpr<>(s, lexem(), functions);
                break;

            case VARIABLE:
                s = ((VarLex) lexems.get(idx)).getName();
                result = new Variable<>(s);
                idx++;
                break;

            case MINUS:
                idx++;
                result = new Negative<>(lexem());
                break;

            case OPEN_BRACKET:
                idx++;
                result = evalLexem(1);
                idx++;

                break;

            default:
                throw new RuntimeException();
        }
        return result;
    }
}
