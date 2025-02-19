package com.day02.jsondata.practiceproblems.convertjavaobjecttojsonobject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertJavaObjectTest {

    @Test
    void testJSONObjectCreation() {

        Car car1 = new Car("BMW", "red", "gasoline", 100000);
        Car car2 = new Car("Toyota", "white", "diesel", 150000);


        JSONObject car = new JSONObject();
        car.put("car1", new JSONObject(car1));
        car.put("car2", new JSONObject(car2));


        assertNotNull(car);
        assertTrue(car.has("car1"));
        assertTrue(car.has("car2"));
        assertEquals("BMW", car.getJSONObject("car1").getString("brand"));
        assertEquals("red", car.getJSONObject("car1").getString("color"));
        assertEquals("Toyota", car.getJSONObject("car2").getString("brand"));
        assertEquals("white", car.getJSONObject("car2").getString("color"));
    }

}