package com.company;
import java.io.*;

public class CSVDataWriter implements DataWriter {
    private String outputFile;
    private FileWriter CSVwriter;

    public CSVDataWriter(String outputFileName) throws IOException {
        outputFile = outputFileName;
        CSVwriter = new FileWriter(outputFile);
    }

    public CSVDataWriter() throws IOException {
        outputFile = "CSVfile.csv";
        CSVwriter = new FileWriter(outputFile);
    }

    public void writeData(String[] data) throws IOException{
        String lineToWrite = String.join(";", data);
        lineToWrite+=System.lineSeparator();
        CSVwriter.write(lineToWrite);
    }

    public void endOfWork(){
        try{
            if (CSVwriter != null)
                CSVwriter.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
