package BlockExceptions;

public class BlockParametersException extends BlockException {
    public BlockParametersException(String message){
        super("Error in the " + message + " parameters");
    }
}
