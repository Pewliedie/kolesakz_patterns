package com.epam.kzta2020.business_objects;

public class Car {
    private String price;
    private String city;
    private String mark;
    private String model;

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }
}
