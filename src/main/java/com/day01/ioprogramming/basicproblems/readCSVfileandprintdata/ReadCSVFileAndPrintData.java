package com.day01.ioprogramming.basicproblems.readCSVfileandprintdata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;





public class ReadCSVFileAndPrintData {
    public static void readCSVFileBufferedReader(String fileName) {
        try {
            FileReader fileReader=new FileReader(fileName);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String []columns=line.split(",");
                System.out.println("ID: "+columns[0]+", Name: "+columns[1]+", Age: "+ columns[2]+", Marks: "+columns[3]);
            }
            bufferedReader.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Error in reading file");
        }

    }
    public static void readCSVFileUsingCSVLibrary(String fileName){
        try {
            FileReader fileReader=new FileReader(fileName);
            CSVReader csvReader=new CSVReader(fileReader);
            String[] columns;
            while ((columns=csvReader.readNext())!=null){
                System.out.println("ID: "+columns[0]+", Name: "+columns[1]+", Age: "+ columns[2]+", Marks: "+columns[3]);


            }


        }catch (CsvValidationException e){
            System.out.println("Error in reading CSV file");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Error in reading file");
        }
    }

}
