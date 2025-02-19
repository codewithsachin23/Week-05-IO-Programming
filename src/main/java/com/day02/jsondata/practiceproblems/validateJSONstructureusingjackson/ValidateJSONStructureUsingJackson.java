package com.day02.jsondata.practiceproblems.validateJSONstructureusingjackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class ValidateJSONStructureUsingJackson {

    public static boolean isValidJson(String json) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static void main(String[] args) {
        JSONObject student1=new JSONObject();
        student1.put("name","sachin shukla");
        student1.put("age",21);

        JSONObject student2=new JSONObject();
        student2.put("name","Suraj Patel");
        student2.put("age",22);

        String invalidJson = "{name:\"John Doe\",age:30}";



        System.out.println("Is valid JSON? " + isValidJson(student1.toString()));
        System.out.println("Is valid JSON? " + isValidJson(student2.toString()));
        System.out.println("Is valid JSON? " + isValidJson(invalidJson));
    }
}
