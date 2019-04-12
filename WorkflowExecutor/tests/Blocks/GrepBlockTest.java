package Blocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GrepBlockTest {

    @Test
    public void execute() {
        GrepBlock grepTest = new GrepBlock();
        List<String> expected = new ArrayList<>();
        expected.add("one two");
        expected.add("three on");
        expected.add("ne four");
        expected.add("ONE");
        expected.add("    one12312312312 ");
        List<String> parameters = new ArrayList<>();
        parameters.add("one");
        try{
            grepTest.setBlockParameters(parameters);
            expected = grepTest.execute(expected);
            List<String> actual = new ArrayList<>();
            actual.add("one two");
            actual.add("    one12312312312 ");
            Assert.assertEquals(expected, actual);
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }

    @Test
    public void setBlockParameters() {
    }
}