package com.day01.ioprogramming.basicproblems.writedatatoaCSVfile;

public class Main {
    public static void main(String[] args) {
        String filename="Employee.csv";
//        WriteDataToCSVFile.writeDataToCSVFileUsingFileWriter(filename);
        WriteDataToCSVFile.writeDataToCSVFileUsingOpenCSV(filename);

    }
}
