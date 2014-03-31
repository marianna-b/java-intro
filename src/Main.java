public class Main {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        String s = args[3];

        double result = ExpressionParser.parse(s).evaluate(x, y, z);

        System.out.println(result);
    }

}