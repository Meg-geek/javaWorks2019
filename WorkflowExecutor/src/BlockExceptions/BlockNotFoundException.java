package BlockExceptions;

public class BlockNotFoundException extends BlockException {
    public BlockNotFoundException(String message){
        super(message + "block not found");
    }
}
