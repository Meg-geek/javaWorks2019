package Blocks;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import BlockExceptions.BlockDescException;
import BlockExceptions.BlockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortBlock extends Block {
    static Logger log = LogManager.getLogger(SortBlock.class);
    public List<String> execute(List<String> args) throws IOException, BlockException{
        List result = args;
        Collections.sort(result);
        log.info("Sort block successfully executed");
        return result;
    }

    public void setBlockParameters(List<String> parameters) throws BlockException{
        if (!parameters.isEmpty())
            throw new BlockDescException("sort");
    }

}
