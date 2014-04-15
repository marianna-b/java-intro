package parser;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Test {
    public static void main(String[] args) {
        String s = "x^9 + y * lb(x ^ 2 + 3)";
        System.out.print("x\t");
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < 100; j++) {

                try {
                    System.out.print(ExpressionParser.parse(s).evaluate(j, i, 0) + "\t");
                } catch (AbstractException e) {
                    System.out.print(e.getMessage() + "\t");
                }
            }
            System.out.println();
        }
    }
}
