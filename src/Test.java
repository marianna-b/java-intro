/**b
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Test {
    public static void main(String[] args) {
        String s = "x----y-----z";
        System.out.println(ExpressionParser.parse(s).evaluate(1, 2, 3));
    }
}
