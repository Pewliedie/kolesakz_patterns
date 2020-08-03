package com.epam.cdp.kzta2020.domain;

import java.util.Optional;

public class KolesaSearchWithPhotoData extends KolesaCommonData{

    private String modelYear;

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public Optional<String> getModelYear() {
        return Optional.ofNullable(modelYear);
    }
}
