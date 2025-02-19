package com.day02.jsondata.handonpracticeproblems.convertJSONtoXMLformat;


public class ConvertJSONToXML {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(json);
            String xml = org.json.XML.toString(jsonObject);
            System.out.println("XML Output:");
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
