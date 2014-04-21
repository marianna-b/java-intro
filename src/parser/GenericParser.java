package parser;

import parser.exceptions.AbstractException;
import parser.expr3.Expression3;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class GenericParser {
    public static void main(String[] args) {
        String expression = args[1];
        switch (args[0]) {
            case ("-i"):

                try {
                    ExpressionParser <NumberInteger> pI;
                    pI = new ExpressionParser<>(expression, new NumberIntegerParser());
                    Expression3 <NumberInteger> resI = pI.parse();

                    NumberInteger xi = new NumberInteger(-100);
                    NumberInteger yi = new NumberInteger(-100);
                    NumberInteger zi = new NumberInteger(0);

                    while (!xi.isMax()) {
                        yi.setMin();
                        while (!yi.isMax()) {

                            try {
                                System.out.print(resI.evaluate(xi, yi, zi) + " ");
                            } catch (AbstractException e) {
                                System.out.print("error ");
                            }

                            yi.inc();
                        }
                        xi.inc();
                        System.out.println();
                    }


                    } catch (AbstractException e) {
                    System.out.println(e.getMessage());
                }

                break;

            case ("-d"):
                NumberDouble xd = new NumberDouble(args[2]);
                NumberDouble yd = new NumberDouble(args[3]);
                NumberDouble zd = new NumberDouble(args[4]);

                try {
                    ExpressionParser <NumberDouble> pD = new ExpressionParser<>(args[1], new NumberDoubleParser());
                    NumberDouble resD = pD.parse().evaluate(xd, yd, zd);

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
                    ExpressionParser <NumberBigInteger> pBI;
                    pBI = new ExpressionParser<>(args[1], new NumberBigIntegerParser());
                    NumberBigInteger resBI = pBI.parse().evaluate(xbi, ybi, zbi);

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
