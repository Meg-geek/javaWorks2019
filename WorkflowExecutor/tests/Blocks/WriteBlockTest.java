package Blocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WriteBlockTest {

    @Test
    public void execute() {
        WriteBlock writeBlockTest = new WriteBlock();
        ReadBlock readExpected = new ReadBlock(), readActual = new ReadBlock();
        List <String> fileName = new ArrayList<>();
        fileName.add("test.txt");
        try{
            readExpected.setBlockParameters(fileName);
            readActual.setBlockParameters(fileName);
            writeBlockTest.setBlockParameters(fileName);
            List <String> expected = readExpected.execute(new ArrayList<String>());
            expected = writeBlockTest.execute(expected);
            expected = readExpected.execute(new ArrayList<String>());
            List<String> actual = readActual.execute(new ArrayList<String>());
            Assert.assertEquals(expected, actual);
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }

    @Test
    public void setBlockParameters() {
    }
}