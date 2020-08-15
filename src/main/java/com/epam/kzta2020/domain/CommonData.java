package com.epam.kzta2020.domain;

import java.util.Optional;

public class CommonData {
    private String priceFrom;
    private String city;
    private String mark;
    private String model;
    private String engineType;

    public void setCity(String city) {
        this.city = city;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Optional<String> getEngineType() {
        return Optional.ofNullable(engineType);
    }

    public Optional<String> getModel() {
        return Optional.ofNullable(model);
    }
}
