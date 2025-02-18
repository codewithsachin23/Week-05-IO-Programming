package com.day01.ioprogramming.advancedproblems.mergetwoCSVfiles;

import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {
    public static void mergeTwoCSVFiles(String file1, String file2, String outputFile) {

        Map<String, Student> studentMap = new HashMap<>();

        // Read students1.csv
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    studentMap.put(parts[0], new Student(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read students2.csv
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && studentMap.containsKey(parts[0])) {
                    studentMap.get(parts[0]).addMarksAndGrade(parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write to merged_students.csv
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Student s : studentMap.values()) {
                bw.write(s.toString() + "\n");
            }
            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
