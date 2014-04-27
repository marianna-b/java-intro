package parser.expr3;

import parser.exceptions.AbstractException;

public interface Expression3 <T extends parser.Number<T>>{
    T evaluate(T x, T y, T z) throws AbstractException;

    String toString();

}