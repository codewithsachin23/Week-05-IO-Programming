package com.day02.jsondata.practiceproblems.createJSONobjectforstudent;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObjectForStudent {
    public static void main(String[] args) {
        JSONArray subjects=new JSONArray();
        subjects.put("maths");
        subjects.put("ioT");
        subjects.put("cloud computing");

        JSONObject student =new JSONObject();
        student.put("name","sachin shukla");
        student.put("age",21);
        student.put("subjects",subjects);
        System.out.println(student);

    }
}
