package com.company;
import java.io.*;


public class WordTextParser implements WordParser {
    private File inputFile;
    private BufferedReader reader;
    private String line;
    private int position = 0;
    public WordTextParser(String inputFileName) throws IOException{
        inputFile = new File(inputFileName);
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        line = reader.readLine();
    }
    public String getWord() throws IOException{
        String nextWord = getNextWord();
        if (nextWord != null)
            return nextWord;
        //если конец файла
        try {
            if (reader != null)
                reader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;}
    private String getNextWord() throws IOException{
        int endFlag = setPositionAndLine();
        if (endFlag == 1)
            return null;
        int endPosition = -1;
        for(int i = position; i < line.length() && endPosition == -1; i++){
            char letter = line.charAt(i);
            if ( !Character.isLetterOrDigit(letter)){
                endPosition = i;
                if (position == endPosition){
                    position++;
                    endPosition = -1;
                }
            }
        }
        if (endPosition == -1)
            endPosition = line.length() - 1;
        if (position >= line.length())
            return null;
        String word;// = line.substring(position, endPosition);
        if (position != endPosition && endPosition != line.length() - 1)
            word = line.substring(position, endPosition);
        else
            word = line.substring(position);
        position = endPosition + 1;
        if (word.length() > 0)
            return word;
        return null;
    }
    /*
     *устанавливает новую позицию, если предыдущая строка считана, и читает новую строку
     * returns 1 if it's the end of the file
     * 0 if we can explore the line
     * */
    private int setPositionAndLine() throws IOException{
        if (position >= line.length()){
            line = reader.readLine();
            while ( (line!=null)&&(line.isEmpty() || !isLettersOrDigits()))
                line = reader.readLine();
            position = 0;
        }
        if (line == null)
            return 1;
        return 0;
    }

    private boolean isLettersOrDigits(){
        for (char c: line.toCharArray()){
            if (Character.isLetterOrDigit(c))
                return true;
        }
        return false;}
}
