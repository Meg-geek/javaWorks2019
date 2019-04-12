package Blocks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import BlockExceptions.BlockArgsException;
import BlockExceptions.BlockDescException;
import BlockExceptions.BlockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteBlock extends Block {
    private String fileName;
    static Logger log = LogManager.getLogger(WriteBlock.class);
    public List<String> execute(List <String> args) throws IOException, BlockException{
        if (args.isEmpty())
            throw new BlockArgsException("writefile");
        FileWriter writer = new FileWriter(new File(fileName));
        for (String line: args){
            writer.write(line);
            writer.write(System.lineSeparator());
        }
        try{
            writer.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        log.info("Write block successfully executed");
        return null;
    }

    public void setBlockParameters(List<String> parameters) throws BlockException{
        if (parameters.isEmpty())
            throw new BlockDescException("writefile");
        fileName = parameters.get(0);
        log.info("WriteBlock parameters are set");
    }
}
