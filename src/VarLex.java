/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class VarLex extends Lexem {

    public final String name;

    public VarLex(String s) {
        super(LexemType.VAR);

        name = s;
    }

    public String getName() {
        return name;
    }

    @Override
    public LexemType getType() {
        return super.getType();
    }
}
