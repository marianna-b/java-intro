package parser;

import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public interface Number <T extends Number<T>> {

    void inc();
    void setMin();
    boolean isMax();

    T sum (T b) throws AbstractException;
    T sub (T b) throws AbstractException;
    T mul (T b) throws AbstractException;
    T div (T b) throws AbstractException;
    T exp (T b) throws AbstractException;


    T neg () throws AbstractException;
}
