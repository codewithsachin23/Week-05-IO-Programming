package com.day02.jsondata.handonpracticeproblems.readaJSONfileandprintall;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadJSONFileAndPrintAllTest {
    @Test
    void readJSONFileAndPrintAll() throws Exception{
        File file=new File("person.json");
        ObjectMapper objectMapper=new ObjectMapper();


            JsonNode rootNode = objectMapper.readTree(file);
            assertEquals(3, rootNode.size(), "The JSON should contain 3 entries.");

            assertEquals("John Doe", rootNode.get(0).get("name").asText());
            assertEquals(25, rootNode.get(0).get("age").asInt());
            assertEquals("john.doe@example.com", rootNode.get(0).get("email").asText());

            assertEquals("rahul ", rootNode.get(1).get("name").asText());
            assertEquals(25, rootNode.get(1).get("age").asInt());
            assertEquals("rahul@gmail.com", rootNode.get(1).get("email").asText());

            assertEquals("sachin ", rootNode.get(2).get("name").asText());
            assertEquals(24, rootNode.get(2).get("age").asInt());
            assertEquals("sachin@gmail.com", rootNode.get(2).get("email").asText());
        }
    }

