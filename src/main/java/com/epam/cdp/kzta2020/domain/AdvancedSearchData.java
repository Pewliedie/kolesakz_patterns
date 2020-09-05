package com.epam.cdp.kzta2020.domain;

import java.util.Optional;

public class AdvancedSearchData extends CommonData {

    private String country;
    private String bodyType;
    private String locationOfWheel;
    private String driveUnit;
    private String engineVolumeFrom;
    private String engineVolumeTo;
    private String engineVolumeAndType;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setLocationOfWheel(String locationOfWheel) {
        this.locationOfWheel = locationOfWheel;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public void setEngineVolumeFrom(String engineVolumeFrom) {
        this.engineVolumeFrom = engineVolumeFrom;
    }

    public void setEngineVolumeTo(String engineVolumeTo) {
        this.engineVolumeTo = engineVolumeTo;
    }

    public void setEngineVolumeAndType(String engineVolumeAndType) {
        this.engineVolumeAndType = engineVolumeAndType;
    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public Optional<String> getBodyType() {
        return Optional.ofNullable(bodyType);
    }

    public Optional<String> getLocationOfWheel() {
        return Optional.ofNullable(locationOfWheel);
    }

    public Optional<String> getDriveUnit() {
        return Optional.ofNullable(driveUnit);
    }

    public Optional<String> getEngineVolumeFrom() {
        return Optional.ofNullable(engineVolumeFrom);
    }

    public Optional<String> getEngineVolumeTo() {
        return Optional.ofNullable(engineVolumeTo);
    }

    public Optional<String> getEngineVolumeAndType() {
        return Optional.ofNullable(engineVolumeAndType);
    }
}
