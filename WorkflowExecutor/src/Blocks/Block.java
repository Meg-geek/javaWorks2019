package Blocks;

import java.io.IOException;
import java.util.List;
import BlockExceptions.*;

public abstract class Block {
    public abstract List<String> execute(List<String> args) throws IOException, BlockException;
    public abstract void setBlockParameters(List<String> parameters) throws BlockException;
    //public Block(){}
}
