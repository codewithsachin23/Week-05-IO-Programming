
package com.day01.ioprogramming.advancedproblems.readlargeCSVfileefficiently;

import static com.day01.ioprogramming.advancedproblems.readlargeCSVfileefficiently.ReadingLargeCSVFileEfficiently.readLargeCSVFile;

public class ReadLargeCSVFileEfficiently {
    public static void main(String[] args) {
        // File path
        String filePath = "large_file_50mb.csv";
        int batchSize = 100;
        readLargeCSVFile(filePath, batchSize);
    }
}
