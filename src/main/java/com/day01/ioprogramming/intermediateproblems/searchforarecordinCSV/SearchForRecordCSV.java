package com.day01.ioprogramming.intermediateproblems.searchforarecordinCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchForRecordCSV {
    public static void searchForRecordCSV(String filename,String empName){
        try{
        FileReader fileReader=new FileReader(filename);
        CSVReader csvReader=new CSVReader(fileReader);
        String[] columns;
        while ((columns=csvReader.readNext())!=null){
            if (columns.length > 1 && columns[1].equalsIgnoreCase(empName)) {
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Department: " + (columns.length > 2 ? columns[2] : "N/A") + ", Salary: " + (columns.length > 3 ? columns[3] : "N/A"));
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
