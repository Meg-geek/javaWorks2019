package Workflow;

import java.io.*;
import java.util.ArrayList;


public class WorkflowFileReader {
    private BufferedReader reader;

    public WorkflowFileReader(String fileName)throws IOException, Exception {
        reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        if (!line.equals("desc"))
            throw new Exception("It's not a workflow descriptor file");
    }

    public ArrayList<BlockInfo> getBlocksInfo() throws IOException, Exception{
        ArrayList<BlockInfo> blocksInfo = new ArrayList<BlockInfo>();
        String line = reader.readLine();
        while (line != null && !line.equals("csed")){
           BlockInfo block = createBlock(line);
           if (block == null){
               throw new Exception("Error in the workflow descriptor file");
           }
           blocksInfo.add(block);
           line = reader.readLine();
        }
        return blocksInfo;
    }

    public ArrayList<Integer> getBlocksScheme() throws IOException, Exception{
        ArrayList<Integer> blocksScheme = new ArrayList<Integer>();
        int character = reader.read();
        StringBuilder blockNumb = new StringBuilder();
        while(character != -1){
            boolean isDigit = Character.isDigit((char)character);
            if (!isDigit && blockNumb.length() != 0){
                blocksScheme.add(Integer.parseInt(blockNumb.toString()));
                blockNumb = new StringBuilder();
            }
            if (isDigit){
                blockNumb.append((char)character);
            }
            //if (!isDigit && (char)character != '-' && (char)character != '>' && (char)character != ' '){
              //  close();
                //throw new Exception("Error in the scheme");
            //}
            character = reader.read();
        }
        if (blockNumb.length() != 0){
            blocksScheme.add(Integer.parseInt(blockNumb.toString()));
        }
        close();
        return blocksScheme;
    }

    private void close(){
        try{
            reader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private BlockInfo createBlock(String line){
        BlockInfo block = null;
        int ID, index, length = line.length();
        StringBuilder idString = new StringBuilder();
        for (index = 0; index < length && Character.isDigit(line.charAt(index)); index++){
            idString.append(line.charAt(index));
        }
        if (index == 0) {//if there is no digits
            return block;
        }
        ID = Integer.parseInt(idString.toString());
        for (;index < length && ( line.charAt(index) == ' '  || line.charAt(index) == '='); index++){
        }
        StringBuilder blockNameString = new StringBuilder();
        for (;index < length && line.charAt(index) != ' '; index++){
            blockNameString.append(line.charAt(index));
        }
        block = new BlockInfo(ID, blockNameString.toString());
        for(;index < length; index++ ){
            StringBuilder blockArgument = new StringBuilder();
            for (;index < length && line.charAt(index) != ' '; index++){
                blockArgument.append(line.charAt(index));
            }
            if (blockArgument.length() > 0)
                block.addParameter(blockArgument.toString());
        }
        return block;
    }

}

class BlockInfo{
    private int blockID;
    private String blockName;
    private ArrayList<String> blockParameters = new ArrayList<String>();

    public BlockInfo(int id, String name){
        blockID = id;
        blockName = name;
    }

    public void addParameter(String arg){
        blockParameters.add(arg);
    }

    public int getID(){
        return blockID;
    }

    public String getBlockName(){
        return blockName;
    }

    public ArrayList<String> getBlockParameters(){
        return blockParameters;
    }
}
