package com.epam.cdp.kzta2020.domain;

import java.util.Optional;

public class KolesaAdvancedSearchData {

    private String price;
    private String country;
    private String vehicleStatus;
    private String bodyType;
    private String engineType;
    private String locationOfWheel;
    private String driveUnit;
    private String engineVolumeFrom;
    private String engineVolumeTo;
    private String engineVolumeAndType;
    private String city;

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
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

    public Optional<String> getPrice() {
        return Optional.ofNullable(price);
    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public Optional<String> getVehicleStatus() {
        return Optional.ofNullable(vehicleStatus);
    }

    public Optional<String> getBodyType() {
        return Optional.ofNullable(bodyType);
    }

    public Optional<String> getEngineType() {
        return Optional.ofNullable(engineType);
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

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }
}
