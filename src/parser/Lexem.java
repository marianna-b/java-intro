package parser;

import parser.exceptions.ParseExpressionException;
import parser.expr3.*;

import java.util.ArrayList;

import static parser.Lexem.LexemType.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Lexem <T> {
    protected final LexemType type;
    protected static final ArrayList <LexemType>[] operation = new ArrayList[6];

    static {

        for (int i = 0; i < 5; i++) {
            operation[i] = new ArrayList<>();
        }

        operation[1].add(PLUS);
        operation[1].add(MINUS);

        operation[2].add(MUL);
        operation[2].add(DIV);

        operation[3].add(EXP);

        operation[4].add(ABS);
        operation[4].add(NOT);
        operation[4].add(MINUS);
        operation[4].add(LOG);
    }

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
        NOT,
        ABS,
        OPEN_BRACKET,
        CLOSE_BRACKET,
        EXP,
        LOG
    }


    public boolean hasPrior(int priority) {
        for (int i = 0; i < operation[priority].size(); i++) {
            if (operation[priority].get(i) == this.type)
                return true;
        }
        return false;
    }

    public Expression3 getBinaryExpr (Expression3 a, Expression3 b) throws ParseExpressionException {
        if (type == PLUS)
            return new Add(a, b);
        else if (type == MINUS)
            return new Subtract(a, b);
        else if (type == MUL)
            return new Multiply(a, b);
        else if (type == DIV)
            return new Divide(a, b);
        else if (type == EXP)
            return new Exp (a, b);

        throw new ParseExpressionException("not a binary operator");
    }

    @Override
    public String toString() {
        return "LexemType: " + type;
    }

    public LexemType getType() {

        return type;
    }
}
