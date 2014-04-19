package parser;

import parser.exceptions.ParseExpressionException;

import java.util.ArrayList;
import java.util.List;

import static parser.Lexem.LexemType.*;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Lexer <T extends Number <T> > {

    private int currLexem = 0;
    private int newLexem = 0;
    private String expression;
    private List<Lexem> result;

    private Lexer (String s, Number a) throws ParseExpressionException {
        currLexem = 0;
        newLexem = 0;
        expression = s;
        result = new ArrayList<>();

        while (newLexem < expression.length()) {
            skipWhitespaces();
            result.add(nextLexem(a));
        }
    }

    public static List<Lexem> getLexems (String s, Number a) throws ParseExpressionException {
        return new Lexer(s, a).result;
    }

    private char currChar() {
        return expression.charAt(currLexem);
    }

    private char newChar() {
        return expression.charAt(newLexem);
    }

    private Lexem nextLexem(Number a) throws ParseExpressionException {
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

            String valStr = expression.substring(currLexem, newLexem);

            if (a.checkNumber(valStr))
                    throw new ParseExpressionException("invalid size of number");

            return new NumLex((Number)a.parseNumber(valStr));
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
