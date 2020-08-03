package com.epam.cdp.kzta2020.domain;

import java.util.Optional;

public class KolesaSearchWithPhotoData {

    private String price;
    private String modelYear;
    private String mark;
    private String city;

    public void setPrice(String price) {
        this.price = price;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Optional<String> getPrice() {
        return Optional.ofNullable(price);
    }

    public Optional<String> getModelYear() {
        return Optional.ofNullable(modelYear);
    }

    public Optional<String> getMark() {
        return Optional.ofNullable(mark);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }
}
