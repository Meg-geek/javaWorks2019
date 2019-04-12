package Workflow;

import Blocks.Block;
import Blocks.BlockFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workflow {
   private WorkflowFileReader reader;

   public Workflow(){

   }

   public void run(String fileName) throws IOException, Exception {
      Map<Integer, Block> blocksMap = new HashMap<Integer, Block>();

      reader = new WorkflowFileReader(fileName);
      ArrayList <BlockInfo> blocksInfo = reader.getBlocksInfo();
      for (BlockInfo block: blocksInfo){
         blocksMap.put(block.getID(), BlockFactory.getInstance().getBlock(block.getBlockName()));
         blocksMap.get(block.getID()).setBlockParameters(block.getBlockParameters());
      }

      ArrayList<Integer> scheme = reader.getBlocksScheme();
      List<String> curData = new ArrayList<String>();
      List <String> newData;
      for(int numb : scheme){
         Block returnGetBlock = blocksMap.get(numb);
         if (returnGetBlock == null)
            throw new Exception("Error in the scheme with block number");
         curData = returnGetBlock.execute(curData);
      }

   }

}
