package Blocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SortBlockTest {

    @Test
    public void execute() {
        SortBlock sortTest = new SortBlock();
        List<String> expected = new ArrayList<>(), actual = new ArrayList<>();
        char alfLetter = 'z', bigLetter = 'Z';
        for (int i = 0; i < 26; i ++){
            expected.add(Character.toString(alfLetter));
            expected.add(Character.toString(bigLetter));
            alfLetter--;
            bigLetter--;
        }
        try{
            expected = sortTest.execute(expected);
            alfLetter = 'a';
            bigLetter = 'A';
            for (int i = 0; i < 26; i++){
                Assert.assertEquals(expected.get(i), Character.toString(bigLetter));
                ++bigLetter;
            }
            for (int i = 0; i < 26; i++){
                Assert.assertEquals(expected.get(i+26), Character.toString(alfLetter));
                ++alfLetter;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Test
    public void setBlockParameters() {
    }
}