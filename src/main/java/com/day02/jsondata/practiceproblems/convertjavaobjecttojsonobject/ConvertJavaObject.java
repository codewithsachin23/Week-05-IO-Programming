package com.day02.jsondata.practiceproblems.convertjavaobjecttojsonobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class ConvertJavaObject {
    public static void main(String[] args) {
        //using Json library
        JSONObject car=new JSONObject();
        Car car1=new Car("BMW","red","gasoline",100000);
        Car car2=new Car("Toyota","white","diesel",150000);
        car.put("car1",new JSONObject(car1));
        car.put("car2",new JSONObject(car2));
        System.out.println(car);

        //using jackson library

        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String carJson=objectMapper.writeValueAsString(car1);
            System.out.println(carJson);

        }catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
