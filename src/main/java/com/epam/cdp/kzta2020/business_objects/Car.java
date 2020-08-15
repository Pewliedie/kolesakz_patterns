package com.epam.cdp.kzta2020.business_objects;

import java.util.Optional;

public class Car {
    private String priceFrom;
    private String priceTo;
    private String city;
    private String mark;
    private String model;

    public void setCity(String city) {
        this.city = city;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public Optional<String> getPriceFrom() {
        return Optional.ofNullable(priceFrom);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getMark() {
        return Optional.ofNullable(mark);
    }

    public Optional<String> getModel() {
        return Optional.ofNullable(model);
    }

    public Optional<String> getPriceTo() {
        return Optional.ofNullable(priceTo);
    }
}
