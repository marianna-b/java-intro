package parser;

import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Test {
    public static void main(String[] args) {

        switch (args[0]) {
            case ("-i"):
                NumberInteger xi = new NumberInteger(args[2]);
                NumberInteger yi = new NumberInteger(args[3]);
                NumberInteger zi = new NumberInteger(args[4]);

                try {
                    NumberInteger resI = (NumberInteger)ExpressionParser.parse(args[1], new NumberInteger("0")).evaluate(xi, yi, zi);
                    System.out.println(resI.val);
                } catch (AbstractException e) {
                    System.out.println(e.getMessage());
                }

                break;

            case ("-d"):
                NumberDouble xd = new NumberDouble(args[2]);
                NumberDouble yd = new NumberDouble(args[3]);
                NumberDouble zd = new NumberDouble(args[4]);

                try {
                    NumberDouble resD = (NumberDouble)ExpressionParser.parse(args[1], new NumberDouble("0")).evaluate(xd, yd, zd);
                    System.out.println(resD.val);
                } catch (AbstractException e) {
                    System.out.println(e.getMessage());
                }

                break;
            case ("-bi"):
                NumberBigInteger xbi = new NumberBigInteger(args[2]);
                NumberBigInteger ybi = new NumberBigInteger(args[3]);
                NumberBigInteger zbi = new NumberBigInteger(args[4]);

                try {
                    NumberBigInteger resBI = (NumberBigInteger)ExpressionParser.parse(args[1], new NumberBigInteger("0")).evaluate(xbi, ybi, xbi);
                    System.out.println(resBI.val);
                } catch (AbstractException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("unexpected type");
        }
    }
}
