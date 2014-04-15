package parser;

public class Const implements Expression3 {

    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int evaluate (int x, int y, int z) {
        return this.value;
    }

   @Override
    public String toString() {
        return Integer.toString(value);

    }
}
