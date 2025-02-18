package com.day01.ioprogramming.basicproblems.readCSVfileandprintdata;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadCSVFileAndPrintDataTest {

    @Test
    void testReadCSVFileBufferedReaderWithValidFile() throws IOException {
        String testFileName = "test_valid.csv";
        File testFile = new File(testFileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("1,John,25,85\n");
            writer.write("2,Jane,22,90\n");
        }

        ReadCSVFileAndPrintData.readCSVFileBufferedReader(testFileName);
        assertTrue(testFile.delete());
    }

    @Test
    void testReadCSVFileBufferedReaderWithEmptyFile() throws IOException {
        String testFileName = "test_empty.csv";
        File testFile = new File(testFileName);
        assertTrue(testFile.createNewFile());

        ReadCSVFileAndPrintData.readCSVFileBufferedReader(testFileName);
        assertTrue(testFile.delete());
    }

    @Test
    void testReadCSVFileBufferedReaderWithFileNotFound() {
        String nonExistentFileName = "non_existent.csv";

        ReadCSVFileAndPrintData.readCSVFileBufferedReader(nonExistentFileName);

    }

    @Test
    void testReadCSVFileBufferedReaderWithMalformedData() throws IOException {
        String testFileName = "test_malformed.csv";
        File testFile = new File(testFileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("1,John,25\n");
        }

        ReadCSVFileAndPrintData.readCSVFileBufferedReader(testFileName);
        assertTrue(testFile.delete());
    }
}