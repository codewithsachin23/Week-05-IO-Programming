package com.day01.ioprogramming.intermediateproblems.modifyaCSVfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSVFile {
    public static void modifyCSVFile(String filename) {
        List<String[]> updatedData = new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(filename);
            CSVReader csvReader=new CSVReader(fileReader);
            String[] columns;
            while ((columns=csvReader.readNext())!=null){
                if(columns.length>3){
                int salary=Integer.parseInt(columns[3]);
               salary*=1.10;
               columns[3]=String.valueOf(salary);
            }
                updatedData.add(columns);
}

        }catch (CsvValidationException e){
            System.out.println("Error in reading CSV file");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Error in reading file");
        }
        try {
            FileWriter fileWriter=new FileWriter(filename);
            CSVWriter csvWriter=new CSVWriter(fileWriter);
            csvWriter.writeAll(updatedData);

            csvWriter.flush();
        }catch (IOException e){
            System.out.println("Error in writing file");
        }

    }
    }

