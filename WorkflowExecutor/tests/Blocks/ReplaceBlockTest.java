package Blocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReplaceBlockTest {

    @Test
    public void execute() {
        ReplaceBlock replaceTest = new ReplaceBlock();
        List<String> expected = new ArrayList<>();
        expected.add("one two");
        expected.add("three one");
        expected.add("one four");
        expected.add("ONE");
        expected.add("    ne12312312312 ");
        List<String> parameters = new ArrayList<>();
        parameters.add("one");
        parameters.add("replacement");
        try{
            replaceTest.setBlockParameters(parameters);
            expected = replaceTest.execute(expected);
            List<String> actual = new ArrayList<>();
            actual.add("replacement two");
            actual.add("three replacement");
            actual.add("replacement four");
            actual.add("ONE");
            actual.add("    ne12312312312 ");
            Assert.assertEquals(expected, actual);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void setBlockParameters() {
    }
}