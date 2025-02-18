package com.day01.ioprogramming.advancedproblems.mergetwoCSVfiles;

public class Main {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        MergeTwoCSVFiles.mergeTwoCSVFiles(file1, file2, outputFile);
    }

}
