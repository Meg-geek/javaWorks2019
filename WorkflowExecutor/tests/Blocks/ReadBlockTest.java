package Blocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadBlockTest {

    @Test
    public void execute() {
        ReadBlock testReadBlock = new ReadBlock();
        List <String> testReadFile = new ArrayList<String>();
        testReadFile.add("testRead.txt");
        try {
            testReadBlock.setBlockParameters(testReadFile);
            List<String> expected = testReadBlock.execute(new ArrayList<String>());
            List<String>actual = new ArrayList<>();
            actual.add("one");
            actual.add("two");
            actual.add("three");
            Assert.assertEquals(expected, actual);
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Test
    public void setBlockParameters() {
    }
}