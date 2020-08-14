package com.epam.kzta2020.domain;

import java.util.Optional;

public class CommonData {
    private String price;
    private String city;
    private String mark;
    private String engineType;

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Optional<String> getPrice() {
        return Optional.ofNullable(price);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getMark() {
        return Optional.ofNullable(mark);
    }

    public Optional<String> getEngineType() {
        return Optional.ofNullable(engineType);
    }
}
