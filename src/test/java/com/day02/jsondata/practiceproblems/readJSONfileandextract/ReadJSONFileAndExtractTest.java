package com.day02.jsondata.practiceproblems.readJSONfileandextract;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadJSONFileAndExtractTest {

    @Test
    public void testMain_ValidJSONFile() throws Exception {
        File testFile = new File("person.json");
        try (PrintWriter writer = new PrintWriter(testFile)) {
            writer.println("{\"name\": \"John Doe\", \"email\": \"johndoe@example.com\"}");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode person = objectMapper.readTree(testFile);

        assertEquals("John Doe", person.get("name").asText());
        assertEquals("johndoe@example.com", person.get("email").asText());

    }


}