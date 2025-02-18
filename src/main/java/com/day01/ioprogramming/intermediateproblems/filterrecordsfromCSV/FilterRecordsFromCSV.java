package com.day01.ioprogramming.intermediateproblems.filterrecordsfromCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSV {

    public static void filterRecordsFromCSV(String fileName){
        try {
        FileReader fileReader=new FileReader(fileName);
        CSVReader csvReader=new CSVReader(fileReader);
        String[] columns;
        while ((columns=csvReader.readNext())!=null){
           int mark=Integer.parseInt(columns[3]);
           if (mark>=80){
               System.out.println("ID: "+columns[0]+", Name: "+columns[1]+", Age: "+ columns[2]+", Marks: "+columns[3]);
           }
        }


    }catch (
    CsvValidationException e){
        System.out.println("Error in reading CSV file");
    }
        catch (
    FileNotFoundException e){
        System.out.println("File not found");
    }catch (
    IOException e){
        System.out.println("Error in reading file");
    }
    }

}
