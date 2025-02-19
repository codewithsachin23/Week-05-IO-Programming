package com.day01.ioprogramming.advancedproblems.readlargeCSVfileefficiently;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingLargeCSVFileEfficiently {
    public static void readLargeCSVFile(String filePath, int batchSize) {
        int recordCount = 0;

        //Try block
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skipping header
            br.readLine();

            List<String> batch = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                batch.add(line);
                recordCount++;

                if (batch.size() == batchSize) {
                    processBatch(batch);
                    // Clearing batch after processing
                    batch.clear();
                    System.out.println("Records Processed: " + recordCount);
                }
            }

            // Processing remaining records if any
            if (!batch.isEmpty()) {
                processBatch(batch);
                System.out.println("Records Processed: " + recordCount);
            }

            System.out.println("Finished processing the file. Total records: " + recordCount);
        }
        //Catch block
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBatch(List<String> batch) {
        // Simulating processing
        for (String record : batch) {
            // Processing each CSV line
        }
    }
}
