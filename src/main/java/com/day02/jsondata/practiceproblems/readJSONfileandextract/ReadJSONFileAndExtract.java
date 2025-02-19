package com.day02.jsondata.practiceproblems.readJSONfileandextract;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONFileAndExtract {
    public static void main(String[] args) {
        File file=new File("person.json");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            JsonNode person=objectMapper.readTree(file);
            System.out.println(person.get("name").asText());
            System.out.println(person.get("email").asText());
        }
        catch (Exception e) {
            System.out.println("exception occured");
        }

    }
}
