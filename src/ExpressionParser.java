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
        currVal = 0;
        nextLexem();
    }

    public static Expression3 parse(String expr) {
        expr = expr.replaceAll("\\s+", "");
        return (new ExpressionParser(expr)).sumLexem();
    }

    private Expression3 sumLexem() {

        Expression3 result;
        System.out.println();
        if (isMinus()) {
            nextLexem();
            result = new Negative(mulLexem());
        } else {
            result = mulLexem();
        }

        while (!isEnd() && (isPlus() || isMinus())) {
            if (isPlus()) {
                nextLexem();
                result = new Add(result, mulLexem());
            } else {
                nextLexem();
                result = new Subtract(result, mulLexem());
            }
        }
        return result;
    }

    private Expression3 mulLexem() {

        Expression3 currMul = lexem();

        while (!isEnd() && (isMul() || isDiv())) {

            if (isMul()) {
                nextLexem();
                currMul = new Multiply(currMul, lexem());
            } else {
                nextLexem();
                currMul = new Divide(currMul, lexem());
            }
        }
        return currMul;
    }

    private Expression3 lexem() {

        Expression3 result;
        System.err.println("");

        if (isConst()) {
            result = new Const(currVal);
            nextLexem();
        } else if (isVariable()) {
            result = new Variable(currVariable);
            nextLexem();
        } else if (isMinus()) {
            nextLexem();
            result = new Negative(lexem());
        } else if (isOpen()) {
            nextLexem();
            result = sumLexem();
            assert isClose();
            nextLexem();
        } else {
            throw new RuntimeException(""); // TODO:
        }
        return result;
    }

    private void nextLexem() {
        currLexem += lengthCurrLexem;

        if (isEnd()) {
            return;
        }

        lengthCurrLexem = 0;

        if (isConst()) {

            while (!isEnd(lengthCurrLexem) && isConst(lengthCurrLexem)) {
                lengthCurrLexem++;
            }

            currVal = Integer.parseInt(expr.substring(currLexem, currLexem + lengthCurrLexem));

        } else if (isVariable()) {

            while (!isEnd(lengthCurrLexem) && isVariable(lengthCurrLexem)) {
                lengthCurrLexem++;
            }
            currVariable = expr.substring(currLexem, currLexem + lengthCurrLexem);

        } else {
            lengthCurrLexem = 1;
        }
    }


    private boolean isConst(int x) {
        return Character.isDigit(expr.charAt(currLexem + x));
    }

    private boolean isVariable(int x) {
        return Character.isLetter(expr.charAt(currLexem + x));
    }

    private boolean isConst() {
        return isConst(0);
    }

    private boolean isVariable() {
        return isVariable(0);
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

    private boolean isEnd(int x) {
        return expr.length() <= currLexem + x;
    }

    private boolean isEnd() {
        return isEnd(0);
    }
}
