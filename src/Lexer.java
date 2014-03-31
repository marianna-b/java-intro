import java.util.ArrayList;
import java.util.List;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Lexer {

    private static int currLexem = 0;
    private static int newLexem = 0;
    private static String expression;

    public static void init(){
        currLexem = 0;
        newLexem = 0;
    }

    public static List <Lexem> getLexems(String s) {
        init();
        expression = s;
        List <Lexem> result = new ArrayList <>();

        while (newLexem < expression.length()) {
            result.add(nextLexem());
        }
        return result;
    }

    private static char currChar() {
        return expression.charAt(currLexem);
    }

    private static char newChar() {
        return expression.charAt(newLexem);
    }

    private static Lexem nextLexem() {
        currLexem = newLexem;
        newLexem++;
        switch (currChar()) {
            case '+':
                return new Lexem(Lexem.LexemType.PLUS);

            case '-':
                return new Lexem(Lexem.LexemType.MINUS);

            case '*':
                return new Lexem(Lexem.LexemType.MUL);

            case '/':
                return new Lexem(Lexem.LexemType.DIV);

            case '(':
                return new Lexem(Lexem.LexemType.OPEN_BRACKET);

            case ')':
                return new Lexem(Lexem.LexemType.CLOSE_BRACKET);
        }
        newLexem--;
        if (Character.isDigit(currChar())) {

            while (newLexem < expression.length() && Character.isDigit(newChar())) {
                newLexem++;
            }

            int val = (int)Long.parseLong(expression.substring(currLexem, newLexem));

            return new NumLex(val);
        }

        while (newLexem < expression.length() && Character.isLetter(newChar())) {
            newLexem++;
        }

        String name = expression.substring(currLexem, newLexem);
        return new VarLex(name);
    }
}
