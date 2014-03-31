/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class ExpressionParser {

    private int currLexem;
    private int lengthCurrLexem;
    private int currVal;
    private String expr;
    private String currVariable;


    public ExpressionParser(String newExpression) {
        expr = newExpression;
        currVariable = "";
        currLexem = 0;
        nextLexem();
        lengthCurrLexem = 0;
        currVal = 0;
    }

    public static Expression3 parse(String expr) {
        return (new ExpressionParser(expr)).sumLexem();
    }

    private Expression3 sumLexem() {

        Expression3 result;

        if (isMinus()) {
            result =  new Negative(mulLexem());
        } else {
            result = mulLexem();
        }

        if (isEnd()) {

            return new Const(0);
        }

        while (isPlus() || isMinus()) {
            if (isPlus()) {
                nextLexem();
                result = new Add(result, mulLexem());
                return result;
            } else {
                nextLexem();
                result = new Subtract(result, mulLexem());
            }
        }
        return result;
    }

    private Expression3 mulLexem() {

        Expression3 currMul = lexem();
        if (isEnd()) {
            return new Const(0);
        }

        while (isMul() || isDiv()) {

            if (isMul()) {
                nextLexem();
                return new Multiply(currMul, lexem());
            } else {
                nextLexem();
                return new Divide(currMul, lexem());
            }
        }
        return currMul;
    }

    private Expression3 lexem() {

        Expression3 result = new Const(1);

        if (!isEnd()) {
            if (isConst()) {
                result = new Const(currVal);
            }

            if (isVariable()) {
                result = new Variable(currVariable);
            }

            if (isMinus()) {
                result = new Negative(lexem());
            }

            if (isOpen()) {
                result = sumLexem();
            }

            if (isClose()) {
                nextLexem();
            }
        }
        return result;
    }

    private void nextLexem() {
        currLexem += lengthCurrLexem;

        if (isEnd()) {
            return;
        }

        lengthCurrLexem = 0;

        while (isWhitespace()) {
            lengthCurrLexem = 1;
            nextLexem();
            return;
        }

        if (isConst()) {

            while (isConst()) {
                lengthCurrLexem++;
            }

            currVal = Integer.parseInt(expr.substring(currLexem, currLexem + lengthCurrLexem));

        } else {
            if (isVariable()) {

                while (isVariable()) {
                    currLexem++;
                }
                currVariable = expr.substring(currLexem, currLexem + lengthCurrLexem);

            }
        }
    }

    private boolean isConst() {
        return Character.isDigit(expr.charAt(currLexem));
    }

    private boolean isVariable() {
        return Character.isLetter(expr.charAt(currLexem));
    }

    private boolean isPlus() {
        return expr.charAt(currLexem) == '+';
    }

    private boolean isMinus() {
        return expr.charAt(currLexem) == '-';
    }

    private boolean isMul() {
        return expr.charAt(currLexem) == '*';
    }

    private boolean isDiv() {
        return expr.charAt(currLexem) == '/';
    }

    private boolean isOpen() {
        return expr.charAt(currLexem) == '(';
    }

    private boolean isClose() {
        return expr.charAt(currLexem) == ')';
    }

    private boolean isWhitespace() {
        return expr.charAt(currLexem) == ')';
    }

    private boolean isEnd() {
        return expr.length() <= currLexem;
    }
}
