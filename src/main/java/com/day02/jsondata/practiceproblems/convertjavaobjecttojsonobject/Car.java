package com.day02.jsondata.practiceproblems.convertjavaobjecttojsonobject;

public class Car {
    private String brand;
    private String color;
    private String fuleType;
    private double price;

    public Car(String brand, String color, String fuleType, double price) {
        this.brand = brand;
        this.color = color;
        this.fuleType = fuleType;
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
    public String getFuleType() {
        return fuleType;
    }
    public double getPrice() {
        return price;
    }
    public String toString(){
        return "{\"brand\":\""+brand+"\",\"color\":\""+color+"\",\"fuleType\":\""+fuleType+"\",\"price\":"+price+"}";
    }
}
