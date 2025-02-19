package com.day02.jsondata.practiceproblems.convertjavaobjecttojson;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertJavaObjectToJSONTest {
    @Test
    void testMainMethodConvertsJavaObjectsToJSONArray() {
        try {
            // Create Student objects as per the main method
            List<Student> students = new ArrayList<>();
            Student s1 = new Student("sachin", 21, new String[]{"maths", "ioT", "cloud computing"});
            Student s2 = new Student("rahul", 22, new String[]{"physics", "chemistry", "biology"});
            Student s3 = new Student("rakesh", 23, new String[]{"maths", "biology", "physics"});
            students.add(s1);
            students.add(s2);
            students.add(s3);

            // Convert the list to a JSONArray
            JSONArray jsonArray = new JSONArray(students);

            // Validate the JSONArray
            assertNotNull(jsonArray, "The generated JSONArray should not be null.");
            assertEquals(3, jsonArray.length(), "The JSONArray should contain 3 elements.");
            assertTrue(jsonArray.toString().contains("sachin"), "The JSON should contain student sachin.");
            assertTrue(jsonArray.toString().contains("rahul"), "The JSON should contain student rahul.");
            assertTrue(jsonArray.toString().contains("rakesh"), "The JSON should contain student rakesh.");
        } catch (Exception e) {
            fail("Exception should not occur during the test: " + e.getMessage());
        }
    }
}