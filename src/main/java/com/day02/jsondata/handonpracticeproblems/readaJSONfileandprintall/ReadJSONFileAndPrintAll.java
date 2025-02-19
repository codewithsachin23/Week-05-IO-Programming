package com.day02.jsondata.handonpracticeproblems.readaJSONfileandprintall;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONFileAndPrintAll {
    public static void main(String[] args) {
        File file=new File("person.json");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            JsonNode jsonNode =objectMapper.readTree(file);
            System.out.println(jsonNode);

        }catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
