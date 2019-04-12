package BlockExceptions;

public class BlockArgsException extends BlockException {
    public BlockArgsException(String message){
        super("Error in the " + message + " arguments");
    }
}
