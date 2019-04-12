package com.company;

import java.io.*;

public class WordTextParser2 implements WordParser {
    private Reader reader;
    public WordTextParser2(String inputFileName) throws IOException{
        reader = new InputStreamReader(new FileInputStream(inputFileName));
    }
    public String getWord() throws IOException{
        StringBuilder word = new StringBuilder();
        if (!reader.ready()){
            close();
            return null;
        }
        char character = (char)reader.read();
        while (reader.ready() && !Character.isLetterOrDigit(character)){
            character = (char)reader.read();
        }

        while (reader.ready() && Character.isLetterOrDigit(character)){
            word.append(character);
            character = (char)reader.read();
        }
        if (word.length() == 0){
            return null;
        }
        return word.toString();
    }

    private void close(){
        try{
            reader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
