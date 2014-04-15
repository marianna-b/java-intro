package parser;

import java.util.ArrayList;
import java.util.List;

import static parser.Lexem.LexemType.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Lexer {

    private int currLexem = 0;
    private int newLexem = 0;
    private String expression;
    private List<Lexem> result;

    private Lexer(String s) throws ParseExpressionException {
        currLexem = 0;
        newLexem = 0;
        expression = s;
        result = new ArrayList<>();

        while (newLexem < expression.length()) {
            skipWhitespaces();
            result.add(nextLexem());
        }
    }

    public static List<Lexem> getLexems (String s) throws ParseExpressionException {
        return new Lexer(s).result;
    }

    private char currChar() {
        return expression.charAt(currLexem);
    }

    private char newChar() {
        return expression.charAt(newLexem);
    }

    private Lexem nextLexem() throws ParseExpressionException {
        skipWhitespaces();
        currLexem = newLexem;
        newLexem++;

        switch (currChar()) {
            case '+':
                return new Lexem(PLUS);

            case '^':
                return new Lexem(EXP);

            case 'l':
                newLexem++;
                return new Lexem(LOG);

            case '~':
                return new Lexem(NOT);

            case 'a':
                newLexem += 2;
                return new Lexem(ABS);

            case '-':
                return new Lexem(MINUS);

            case '*':
                return new Lexem(MUL);

            case '/':
                return new Lexem(DIV);

            case '(':
                return new Lexem(OPEN_BRACKET);

            case ')':
                return new Lexem(CLOSE_BRACKET);
        }
        newLexem--;
        if (Character.isDigit(currChar())) {
            while (newLexem < expression.length() && Character.isDigit(newChar())) {
                newLexem++;
            }

            long valLong = Long.parseLong(expression.substring(currLexem, newLexem));
            if (valLong > Integer.MAX_VALUE)
                    throw new ParseExpressionException("invalid size of number");

            return new NumLex((int)valLong);
        }
        if (Character.isAlphabetic(currChar())) {
            while (newLexem < expression.length() && Character.isLetter(newChar())) {
                newLexem++;
            }

            String name = expression.substring(currLexem, newLexem);
            return new VarLex(name);
        }
        throw new ParseExpressionException("invalid symbol");
    }

    private void skipWhitespaces() {
        while (newLexem < expression.length() && Character.isWhitespace(expression.charAt(newLexem)))
            newLexem++;

    }
}
