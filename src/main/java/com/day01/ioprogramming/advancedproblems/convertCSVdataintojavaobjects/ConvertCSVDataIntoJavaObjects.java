package com.day01.ioprogramming.advancedproblems.convertCSVdataintojavaobjects;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVDataIntoJavaObjects {
    public static List<CreatingAObject> convertCSVDataIntoJavaObjects(String filename){
        List<CreatingAObject> dataList=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(filename);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String []data=line.split(",");
                String id=data[0];
                String name=data[1];
                String age=data[2];
                String marks=data[3];
                CreatingAObject creatingAObject=new CreatingAObject(id,name,age,marks);
                dataList.add(creatingAObject);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Error in reading file");
        }
        return dataList;
    }
}
