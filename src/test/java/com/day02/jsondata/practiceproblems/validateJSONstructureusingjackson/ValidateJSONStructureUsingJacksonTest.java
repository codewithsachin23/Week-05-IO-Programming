package com.day02.jsondata.practiceproblems.validateJSONstructureusingjackson;

import org.junit.jupiter.api.Test;

import static com.day02.jsondata.practiceproblems.validateJSONstructureusingjackson.ValidateJSONStructureUsingJackson.isValidJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateJSONStructureUsingJacksonTest {

    @Test
    void testMainMethod() {
        String validJson1 = "{\"name\":\"sachin shukla\",\"age\":21}";
        String validJson2 = "{\"name\":\"Suraj Patel\",\"age\":22}";
        String invalidJson = "{name:\"John Doe\",age:30}";

        boolean result1 = isValidJson(validJson1);
        assertEquals(true, result1, "Expected validJson1 to be valid JSON");

        boolean result2 = isValidJson(validJson2);
        assertEquals(true, result2, "Expected validJson2 to be valid JSON");

        boolean result3 = isValidJson(invalidJson);
        assertEquals(false, result3, "Expected invalidJson to be invalid JSON");
    }
}