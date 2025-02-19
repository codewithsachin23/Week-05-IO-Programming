package com.day01.ioprogramming.advancedproblems.detectduplicatesCSVfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectingDuplicatesInACSVFile {
    public static void detectDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();

                if (!uniqueIds.add(id)) {
                    duplicates.add(line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicates) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
