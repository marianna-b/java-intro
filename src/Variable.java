public class Variable implements Expression3 {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        double result = 0;

        switch (name.charAt(0)) {

            case 'x' :
                result =  x;
                break;

            case 'y' :
                result =  y;
                break;

            case 'z':
                result =  z;
                break;

        }
        return result;
    }
}
