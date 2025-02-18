package com.day01.ioprogramming.basicproblems.readandcountrowsCSVfile;

public class Main {
    public static void main(String[] args) {
        String fileName="ReadData.csv";
        int rowCount=new ReadAndCountRowsInCSVFile().readAndCountRowsInCSVFile(fileName);
        System.out.println("Total number of rows in CSV file is "+rowCount);
    }
}
