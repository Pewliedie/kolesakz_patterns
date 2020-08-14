package com.epam.kzta2020.domain;

import java.util.Optional;

public class PostAdData extends CommonData {

    private String category1;
    private String category2;
    private String model;
    private String modelYear;
    private String engineModification;
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

    public void setModel(String model) {
        this.model = model;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public void setEngineModification(String engineModification) {
        this.engineModification = engineModification;
    }

    public Optional<String> getCategory1() {
        return Optional.ofNullable(category1);
    }

    public Optional<String> getCategory2() {
        return Optional.ofNullable(category2);
    }

    public Optional<String> getModel() {
        return Optional.ofNullable(model);
    }

    public Optional<String> getModelYear() {
        return Optional.ofNullable(modelYear);
    }

    public Optional<String> getEngineModification() {
        return Optional.ofNullable(engineModification);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
