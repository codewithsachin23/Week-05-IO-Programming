package com.day02.jsondata.handonpracticeproblems.generateJSONreportfromdatabaserecords;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class GenerateJSONReportFromDatabaseRecords {
    public static void main(String[] args) {
        try {
            // database records as a list
            List<Student> students = Arrays.asList(
                    new Student("John Doe", 25, "john.doe@example.com"),
                    new Student("Jane Smith", 22, "jane.smith@example.com"),
                    new Student("Mike Johnson", 28, "mike.johnson@example.com")
            );

            // Convert list to JSON and write to file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("students_report.json"), students);

            System.out.println("JSON report generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
