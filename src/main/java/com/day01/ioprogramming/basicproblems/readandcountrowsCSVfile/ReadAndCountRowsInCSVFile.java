package com.day01.ioprogramming.basicproblems.readandcountrowsCSVfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRowsInCSVFile {
    public static int readAndCountRowsInCSVFile(String fileName){
        try {
            FileReader fileReader=new FileReader(fileName);
            CSVReader csvReader=new CSVReader(fileReader);
            int rowCount=0;
            String[] columns;
            while ((columns=csvReader.readNext())!=null){
                rowCount++;
            }
return rowCount;
        }catch (CsvValidationException e){
            System.out.println("Error in reading CSV file");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Error in reading file");
        }
      return 0;
    }
}
