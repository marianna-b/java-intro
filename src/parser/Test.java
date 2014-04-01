package parser;

/**b
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Test {
    public static void main(String[] args) {
        String s = "x";
        System.out.println(ExpressionParser.parse(s).evaluate(1, 0, 0));
    }
}
