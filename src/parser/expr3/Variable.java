package parser.expr3;

import parser.exceptions.AbstractException;
import parser.exceptions.UnknownVariableException;

public class Variable <T extends parser.Number<T>> implements Expression3 <T> {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public T evaluate(T x, T y, T z) throws AbstractException {
        T result;

        switch (name) {

            case "x" :
                result =  x;
                break;

            case "y" :
                result =  y;
                break;

            case "z":
                result =  z;
                break;

            default:
                throw new UnknownVariableException("unknown variable");

        }
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
