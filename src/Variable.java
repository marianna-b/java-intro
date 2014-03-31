public class Variable implements Expression3 {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int result = 0;

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

        }
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
