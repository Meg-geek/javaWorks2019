package Blocks;

import java.io.IOException;
import java.util.List;

import BlockExceptions.BlockException;
import BlockExceptions.BlockDescException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplaceBlock extends Block{
    static Logger log = LogManager.getLogger(ReplaceBlock.class);
    private String word1, word2;
    public List<String> execute(List<String> args) throws IOException, BlockException{
        for (int i = 0; i < args.size(); i++){
            args.set(i, args.get(i).replaceAll(word1, word2));
        }
        log.info("Replace block successfully executed");
        return args;
    }

    public void setBlockParameters(List<String> parameters) throws BlockException{
        if (parameters.size() < 2){
            throw new BlockDescException("replace");
        }
        word1 = parameters.get(0);
        word2 = parameters.get(1);
        log.info("ReplaceBlock parameters are set");
    }
}
