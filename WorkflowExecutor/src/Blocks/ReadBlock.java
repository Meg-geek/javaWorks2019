package Blocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BlockExceptions.BlockException;
import BlockExceptions.BlockArgsException;
import BlockExceptions.BlockDescException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadBlock extends Block {
    static Logger log = LogManager.getLogger(ReadBlock.class);
    private String fileName;
    public List<String> execute(List<String> args) throws IOException, BlockException {
       //это нужно вообще?
        if (!args.isEmpty())
            throw new BlockArgsException("readfile");
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> linesList = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null){
            linesList.add(line);
            line = reader.readLine();
        }
        try{
            reader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        log.info("Read block successfully executed");
        return linesList;
    }

    public void setBlockParameters(List<String> parameters) throws BlockException{
        if (parameters.isEmpty())
            throw new BlockDescException("readfile");
        fileName = parameters.get(0);
        log.info("ReadBlock parameters are set");
    }
    //public ReadBlock(){}
}
