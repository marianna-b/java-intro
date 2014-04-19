package parser.exceptions;

import parser.Lexem;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class InvalidLexemException extends ParseExpressionException {
    public InvalidLexemException(Lexem l) {
        super("invalid lexem " + l);
    }
}
