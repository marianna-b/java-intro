package parser.expr3;

public class Const <T extends parser.Number<T>> implements Expression3 <T> {

    private final T value;

    public Const(T value) {
        this.value = value;
    }

    @Override
    public T evaluate (T x, T y, T z) {
        return this.value;
    }

}
