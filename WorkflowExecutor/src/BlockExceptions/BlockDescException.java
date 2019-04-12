package BlockExceptions;

public class BlockDescException extends BlockException {
    public BlockDescException(String message){
        super("Error in the " + message + " description");
    }
}
