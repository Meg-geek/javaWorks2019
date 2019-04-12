package Blocks;

import BlockExceptions.BlockException;
import BlockExceptions.BlockDescException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrepBlock extends Block{
    private String word;
    static Logger log = LogManager.getLogger(GrepBlock.class);
    public List<String> execute(List<String> args) throws IOException, BlockException {
        ArrayList<String> rightStrings = new ArrayList<String>();
        for (String line: args){
            if (line.contains(word))
                rightStrings.add(line);
        }
        log.info("Grep block successfully executed");
        return rightStrings;
    }

    public void setBlockParameters(List<String> parameters) throws BlockException{
        if (parameters.isEmpty())
            throw new BlockDescException("grep");
        word = parameters.get(0);
        log.info("GrepBlock parameters are set");
    }
}
