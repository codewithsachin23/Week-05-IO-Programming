package com.day01.ioprogramming.basicproblems.writedatatoaCSVfile;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WriteDataToCSVFileTest {
    @Test
    void testWriteDataToCSVFileUsingOpenCSVTest() throws IOException {
        // Arrange
        String fileName = "testOpenCSVContentValidation.csv";
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        System.setIn(new java.io.ByteArrayInputStream("1\nJohn Doe\nEngineering\n50000\n2\nJane Doe\nHR\n60000\n".getBytes()));


        WriteDataToCSVFile.writeDataToCSVFileUsingOpenCSV(fileName);


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();
            String firstEmployeeData = reader.readLine();
            String secondEmployeeData = reader.readLine();

            assertEquals("ID, Name, Department, Salary", header, "Header row does not match");
            assertEquals("1,John Doe,Engineering,50000", firstEmployeeData, "First employee data does not match");
            assertEquals("2,Jane Doe,HR,60000", secondEmployeeData, "Second employee data does not match");
        } finally {
            file.delete();
        }
    }

    @Test
    void testWriteDataToCSVFileUsingFileWriterTest() throws IOException {
        String fileName = "testContentValidation.csv";
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        System.setIn(new java.io.ByteArrayInputStream("1\nJohn Doe\nEngineering\n50000\n".getBytes()));

        WriteDataToCSVFile.writeDataToCSVFileUsingFileWriter(fileName);


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();
            String employeeData = reader.readLine();

            assertEquals("ID, Name, Department, Salary", header, "Header row does not match");
            assertEquals("1,John Doe,Engineering,50000.0", employeeData, "Employee data does not match");
        } finally {
            file.delete();
        }
    }
}