package com.company;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class MutableInt{
    private int value = 1;
    public int get(){
       return value;
    }
    public void increment(){
        value++;
    }
}

public class WordCounter {
    private int words_amount = 0;
    public void makeCSVFile(String fileName) throws IOException {
        WordTextParser2 parser = new WordTextParser2(fileName);
        //WordTextParser parser = new WordTextParser(fileName);
        Map <String, Integer> wordAmountMap = new HashMap<String, Integer>();
        String word = parser.getWord();
        while(word != null){
           words_amount++;
           wordAmountMap.merge(word, 1, Integer::sum);
           word = parser.getWord();
        }
        List<Map.Entry<String, Integer>> wordsList =
                wordAmountMap.entrySet()
                .stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        int ret = o2.getValue().compareTo(o1.getValue());
                        return (ret == 0) ? o1.getKey().compareTo(o2.getKey()): ret;
                    }
                })
                .collect(Collectors.toList());
        CSVDataWriter dataCSVWriter = new CSVDataWriter();
        for (Map.Entry<String, Integer> item: wordsList){
            String[] printLine = new String[3];
            int wordAmount = item.getValue();
            printLine[0] = item.getKey();
            printLine[1] = Integer.toString(wordAmount);
            printLine[2] = String.format( "%.4f",(wordAmount/(double)words_amount));
            dataCSVWriter.writeData(printLine);
        }
        dataCSVWriter.endOfWork();
    }
}
