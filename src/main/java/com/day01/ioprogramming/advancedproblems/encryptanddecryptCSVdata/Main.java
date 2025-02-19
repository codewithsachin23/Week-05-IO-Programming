package com.day01.ioprogramming.advancedproblems.encryptanddecryptCSVdata;
import static com.day01.ioprogramming.advancedproblems.encryptanddecryptCSVdata.CsvEncryptDecrypt.readDecryptedCsv;
import static com.day01.ioprogramming.advancedproblems.encryptanddecryptCSVdata.CsvEncryptDecrypt.writeEncryptedCsv;

public class Main {
    public static void main(String[] args) throws Exception {
        //File path
        String csvFile = "Employee.csv";

        //Method calling
        writeEncryptedCsv(csvFile);
        readDecryptedCsv(csvFile);
    }
}
