package Blocks;
import BlockExceptions.BlockException;
import BlockExceptions.BlockNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BlockFactory {
    static Logger log = LogManager.getLogger(BlockFactory.class);
    private static volatile BlockFactory instance;
    private Properties config;
    InputStream input = null;
    private BlockFactory() throws IOException {
        config = new Properties();
        config.load(BlockFactory.class.getResourceAsStream("config.properties"));
    }

    public static BlockFactory getInstance() throws  IOException{
        log.info("getInstance() - enter");
        BlockFactory localInstance = instance;
        if (localInstance == null){
            synchronized (BlockFactory.class){
                localInstance = new BlockFactory();
                instance = localInstance;
            }
        }
        return instance;
    }

    public Block getBlock(String name) throws Exception {
     if (config.containsKey(name)){
         log.info("create a class " + name);
         Class classNeeded = Class.forName(config.getProperty(name));
         return (Block)classNeeded.getDeclaredConstructor().newInstance();
     }
     log.error("can't create class "+name);
     throw new BlockNotFoundException(name);
    }
}
