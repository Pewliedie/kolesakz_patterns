package com.epam.cdp.kzta2020.domain;

import java.util.Optional;

public class KolesaPostAdData {

    private String category1;
    private String category2;
    private String mark;
    private String model;
    private String modelYear;
    private String engineType;
    private String engineModification;
    private String price;
    private String city;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setEngineModification(String engineModification) {
        this.engineModification = engineModification;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Optional<String> getCategory1() {
        return Optional.ofNullable(category1);
    }

    public Optional<String> getCategory2() {
        return Optional.ofNullable(category2);
    }

    public Optional<String> getMark() {
        return Optional.ofNullable(mark);
    }

    public Optional<String> getModel() {
        return Optional.ofNullable(model);
    }

    public Optional<String> getModelYear() {
        return Optional.ofNullable(modelYear);
    }

    public Optional<String> getEngineType() {
        return Optional.ofNullable(engineType);
    }

    public Optional<String> getEngineModification() {
        return Optional.ofNullable(engineModification);
    }

    public Optional<String> getPrice() {
        return Optional.ofNullable(price);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
