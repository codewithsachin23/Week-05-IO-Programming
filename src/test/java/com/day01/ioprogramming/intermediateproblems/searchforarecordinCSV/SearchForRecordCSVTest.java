package com.day01.ioprogramming.intermediateproblems.searchforarecordinCSV;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchForRecordCSVTest {



    @Test
    void testSearchForRecordCSVTest() throws IOException {
        File tempFile = File.createTempFile("test", ".csv");
        tempFile.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("1,John,HR,50000\n");
            writer.write("2,Alice,IT,60000\n");
            writer.write("3,John,Finance,55000\n");
        }
        StringBuilder output = new StringBuilder();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                output.append((char) b);
            }
        }));
    }
}