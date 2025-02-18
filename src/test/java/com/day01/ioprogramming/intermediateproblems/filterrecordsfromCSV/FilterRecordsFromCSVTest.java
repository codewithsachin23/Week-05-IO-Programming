package com.day01.ioprogramming.intermediateproblems.filterrecordsfromCSV;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterRecordsFromCSVTest {


    @Test
    void testFilterRecordsWithValidCSV() throws IOException, CsvValidationException {
        // Arrange
        String testFileName = "testValid.csv";
        FileWriter writer = new FileWriter(testFileName);
        writer.append("1,sachin,25,85\n");
        writer.append("2,suraj,23,75\n");
        writer.append("3,vivek,28,90\n");
        writer.close();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FilterRecordsFromCSV.filterRecordsFromCSV(testFileName);


        String output = outputStream.toString();
        assertTrue(output.contains("ID: 1, Name: sachin, Age: 25, Marks: 85"));
        assertTrue(output.contains("ID: 3, Name: vivek, Age: 28, Marks: 90"));
    }


    @Test
    void testFilterRecordsWithNonExistentFile() {
        // Arrange
        String testFileName = "nonExistentFile.csv";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        FilterRecordsFromCSV.filterRecordsFromCSV(testFileName);

        // Assert
        String output = outputStream.toString();
        assertTrue(output.contains("File not found"));
    }


}