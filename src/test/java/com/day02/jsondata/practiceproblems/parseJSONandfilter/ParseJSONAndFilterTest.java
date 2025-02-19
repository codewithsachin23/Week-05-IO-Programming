package com.day02.jsondata.practiceproblems.parseJSONandfilter;

import com.day02.jsondata.practiceproblems.convertjavaobjecttojson.Student;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParseJSONAndFilterTest {
    @Test
    void testFilterStudentsOlderThan25() throws Exception {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("sachin", 21, new String[]{"maths", "ioT", "cloud computing"});
        Student s2 = new Student("rahul", 26, new String[]{"physics", "chemistry", "biology"});
        Student s3 = new Student("rakesh", 23, new String[]{"maths", "biology", "physics"});
        students.add(s1);
        students.add(s2);
        students.add(s3);

        JSONArray jsonArray = new JSONArray(students);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonArray.toString());
        ArrayNode filteredArray = objectMapper.createArrayNode();

        for (JsonNode jsonNode1 : rootNode) {
            if (jsonNode1.get("age").asInt() > 25) {
                filteredArray.add(jsonNode1);
            }
        }

        assertEquals(1, filteredArray.size(), "There should be exactly one student older than 25");
        assertEquals("rahul", filteredArray.get(0).get("name").asText(), "The student older than 25 should be 'rahul'");
    }
}