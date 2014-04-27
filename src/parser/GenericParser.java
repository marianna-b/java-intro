package parser;

import parser.exceptions.AbstractException;
import parser.expr3.Expression3;

import java.math.BigInteger;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class GenericParser {
    public static final BigInteger MinusHundred = BigInteger.ONE.multiply(BigInteger.TEN.multiply(BigInteger.TEN)).negate();

    public static void main(String[] args) {
        String expression = args[1];
        switch (args[0]) {
            case ("-i"):
                    ExpressionParser <NumberInteger> pI;
                    pI = new ExpressionParser<>(expression, new NumberIntegerParser());
                    Expression3 <NumberInteger> resI = pI.parse(new FunctionList(new NumberInteger()));

                    NumberInteger xi = new NumberInteger(-100);
                    NumberInteger yi = new NumberInteger(-100);
                    NumberInteger zi = new NumberInteger(0);

                    while (!xi.isMax()) {
                        yi.setMin();
                        while (!yi.isMax()) {

                            try {
                                NumberInteger b = resI.evaluate(xi, yi, zi);
                                int a = (b.val);
                                System.out.print(a + " ");
                            } catch (AbstractException e) {
                                System.out.print("error ");
                            }

                            yi.inc();
                        }
                        xi.inc();
                        System.out.println();
                    }

                break;

            case ("-d"):
                NumberDouble xd = new NumberDouble(-100.0);
                NumberDouble yd = new NumberDouble(-100.0);
                NumberDouble zd = new NumberDouble(0.0);



                ExpressionParser <NumberDouble> pD = new ExpressionParser<>(args[1], new NumberDoubleParser());
                Expression3 <NumberDouble> resD = pD.parse(new FunctionList(new NumberDouble()));


                while (!xd.isMax()) {
                    yd.setMin();
                    while (!yd.isMax()) {

                        try {
                            System.out.print(resD.evaluate(xd, yd, zd).val + " ");
                        } catch (AbstractException e) {
                            System.out.print("error ");
                        }

                        yd.inc();
                    }
                    xd.inc();
                    System.out.println();
                }

                break;
            case ("-bi"):
                NumberBigInteger xbi = new NumberBigInteger(MinusHundred);
                NumberBigInteger ybi = new NumberBigInteger(MinusHundred);
                NumberBigInteger zbi = new NumberBigInteger(BigInteger.ZERO);

                ExpressionParser <NumberBigInteger> pBI;
                pBI = new ExpressionParser<>(expression, new NumberBigIntegerParser());
                Expression3 <NumberBigInteger> resBI = pBI.parse(new FunctionList(new NumberBigInteger()));

                while (!xbi.isMax()) {
                    ybi.setMin();
                    while (!ybi.isMax()) {

                        try {
                            System.out.print(resBI.evaluate(xbi, ybi, zbi).val + " ");
                        } catch (AbstractException e) {
                            System.out.print("error ");
                        }

                        ybi.inc();
                    }
                    xbi.inc();
                    System.out.println();
                }
                break;
            default:
                System.out.println("unexpected type");
        }
    }
}
