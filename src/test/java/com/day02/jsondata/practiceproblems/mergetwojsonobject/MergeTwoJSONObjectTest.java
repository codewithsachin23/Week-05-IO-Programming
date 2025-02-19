package com.day02.jsondata.practiceproblems.mergetwojsonobject;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeTwoJSONObjectTest {
    @Test
    void testMergingTwoJsonObjects() {
        // Prepare input JSON Objects
        JSONObject student1 = new JSONObject();
        student1.put("name", "sachin shukla");
        student1.put("age", 21);

        JSONObject student2 = new JSONObject();
        student2.put("name", "Suraj Patel");
        student2.put("age", 22);

        // Create merged JSON as `main` does in the class
        JSONObject mergedStudent = new JSONObject(student1);
        mergedStudent.put("Student1", student1);
        mergedStudent.put("Student2", student2);

        // Validate the merged structure
        assertTrue(mergedStudent.has("Student1"));
        assertTrue(mergedStudent.has("Student2"));

        // Validate content of Student1
        JSONObject retrievedStudent1 = mergedStudent.getJSONObject("Student1");
        assertEquals("sachin shukla", retrievedStudent1.getString("name"));
        assertEquals(21, retrievedStudent1.getInt("age"));

        // Validate content of Student2
        JSONObject retrievedStudent2 = mergedStudent.getJSONObject("Student2");
        assertEquals("Suraj Patel", retrievedStudent2.getString("name"));
        assertEquals(22, retrievedStudent2.getInt("age"));
    }
}