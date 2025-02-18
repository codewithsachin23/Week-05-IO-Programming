package com.day01.ioprogramming.basicproblems.readCSVfileandprintdata;

public class Main {
    public static void main(String[] args) {
        String fileName = "readData.csv";
        System.out.println("using BufferedReader");
        ReadCSVFileAndPrintData.readCSVFileBufferedReader(fileName);
        System.out.println("using OpenCSV");
        ReadCSVFileAndPrintData.readCSVFileUsingCSVLibrary(fileName);
    }
}
