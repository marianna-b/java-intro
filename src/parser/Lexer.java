package parser;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Lexer <T extends Number<T>> {

    private int currLexem = 0;
    private int newLexem = 0;
    private String expression;
    private List<Lexem<T>> result;


    public Lexer (String s, NumberParser<T> a) {
        currLexem = 0;

        newLexem = 0;
        expression = s;
        result = new ArrayList<>();

        while (newLexem < expression.length()) {
            skipWhitespaces();
            if (newLexem < expression.length())
                result.add(nextLexem(a));
        }
    }

    public List<Lexem <T>> getLexems(){
        return result;
    }

    private char currChar() {
        return expression.charAt(currLexem);
    }

    private char newChar() {
        return expression.charAt(newLexem);
    }

    private Lexem<T> nextLexem(NumberParser<T> a) {
        skipWhitespaces();
        currLexem = newLexem;
        newLexem++;

        switch (currChar()) {
            case '+':
                return new Lexem<>(Lexem.LexemType.PLUS);

            case '^':
                return new Lexem<>(Lexem.LexemType.EXP);

            case '~':
                return new Lexem<>(Lexem.LexemType.NOT);

            case '-':
                return new Lexem<>(Lexem.LexemType.MINUS);

            case '*':
                return new Lexem<>(Lexem.LexemType.MUL);

            case '/':
                return new Lexem<>(Lexem.LexemType.DIV);

            case '(':
                return new Lexem<>(Lexem.LexemType.OPEN_BRACKET);

            case ')':
                return new Lexem<>(Lexem.LexemType.CLOSE_BRACKET);
        }
        newLexem--;
        if (Character.isDigit(currChar())) {
            getInt();
            if (newLexem < expression.length())
                if (newChar() == '.') {
                    newLexem++;
                    getInt();
                }
            if (newLexem < expression.length())
                if (newChar() == 'e' || newChar() == 'E') {
                    newLexem++;
                    getInt();
                }

            T curr = a.parseNumber(expression.substring(currLexem, newLexem));
            return new NumLex<>(curr);
        }

        while (newLexem < expression.length() && Character.isLetter(newChar())) {
            newLexem++;
        }

        String name = expression.substring(currLexem, newLexem);
        skipWhitespaces();

        if (newLexem < this.expression.length() && newChar() == '(')
            return new StringLex<>(name);

        return new VarLex<>(name);

    }

    private void getInt() {
        if (newChar() == '-')
            newLexem++;
        while (newLexem < expression.length() && Character.isDigit(newChar())) {
            newLexem++;
        }
    }

    private void skipWhitespaces() {
        while (newLexem < expression.length() && Character.isWhitespace(expression.charAt(newLexem)))
            newLexem++;
    }

}
