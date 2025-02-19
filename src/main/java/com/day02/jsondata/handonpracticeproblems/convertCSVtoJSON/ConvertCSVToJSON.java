package com.day02.jsondata.handonpracticeproblems.convertCSVtoJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;


public class ConvertCSVToJSON {

    public static void convertCSVToJSON(String csvFilePath, String jsonFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
             FileWriter writer = new FileWriter(jsonFilePath)) {

            String[] headers = br.readLine().split(",");
            JSONArray jsonArray = new JSONArray();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], data[i]);
                }
                jsonArray.put(jsonObject);
            }

            writer.write(jsonArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String csvFilePath="sampleData.csv";
        String jsonFilePath="person.json";
        convertCSVToJSON(csvFilePath,jsonFilePath);
    }
}
