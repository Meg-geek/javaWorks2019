package com.company;
import java.io.*;
public class Main {

    public static void main(String[] args) {

        System.out.println(new File(".").getAbsolutePath());
        WordCounter wordCounter = new WordCounter();
        try{
            if (args.length > 0) {
                wordCounter.makeCSVFile("test.txt");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
