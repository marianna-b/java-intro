package parser;

import parser.expr3.*;

import java.util.List;


/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser <T extends Number<T>> {
    private List<Lexem <T>> lexems;
    private int idx;

    public ExpressionParser(String expression, NumberParser<T> a) {
        idx = 0;
        Lexer <T> curr = new Lexer<>(expression, a);
        lexems = curr.getLexems();
    }


    public Expression3<T> parse(FunctionList f) {
        return evalLexem(1, f);
    }


    private Expression3 <T> evalLexem(int priority, FunctionList f){
        if (priority > 4) {
            return lexem(f);
        }

        if (priority == 3)
            return evalExp(f);

        Expression3<T> result;
        result = evalLexem(priority + 1, f);

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(priority))) {
            Lexem<T> prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalLexem(priority + 1, f));
        }
        return result;
    }

    private Expression3 <T> evalExp(FunctionList f) {
        Expression3 <T> result = lexem(f);

        while (idx < lexems.size() && (lexems.get(idx).hasPrior(3))) {
            Lexem<T> prevIdx = lexems.get(idx);
            idx++;
            result = prevIdx.getBinaryExpr(result, evalExp(f));
        }
        return result;
    }

    private Expression3<T> lexem(FunctionList f) {

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
                result = new StringExpression<>(s, lexem(f), f);
                break;

            case VARIABLE:
                s = ((VarLex) lexems.get(idx)).getName();
                result = new Variable<>(s);
                idx++;
                break;

            case MINUS:
                idx++;
                result = new Negative<>(lexem(f));
                break;

            case OPEN_BRACKET:
                idx++;
                result = evalLexem(1, f);
                idx++;

                break;

            default:
                throw new RuntimeException();
        }
        return result;
    }
}
