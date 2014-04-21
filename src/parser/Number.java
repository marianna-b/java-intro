package parser;

import parser.exceptions.AbstractException;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public interface Number <T> {

    T sum (T b) throws AbstractException;
    T sub (T b) throws AbstractException;
    T mul (T b) throws AbstractException;
    T div (T b) throws AbstractException;
    T exp (T b) throws AbstractException;


    T abs () throws AbstractException;
    T neg () throws AbstractException;
    T log () throws AbstractException;
    //T not () throws AbstractException;

}
