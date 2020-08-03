package com.epam.cdp.kzta2020.domain;

public class KolesaTestTerm {

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

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEngineVolumeFrom() {
        return engineVolumeFrom;
    }

    public void setEngineVolumeFrom(String engineVolumeFrom) {
        this.engineVolumeFrom = engineVolumeFrom;
    }

    public String getEngineVolumeTo() {
        return engineVolumeTo;
    }

    public void setEngineVolumeTo(String engineVolumeTo) {
        this.engineVolumeTo = engineVolumeTo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getLocationOfWheel() {
        return locationOfWheel;
    }

    public void setLocationOfWheel(String locationOfWheel) {
        this.locationOfWheel = locationOfWheel;
    }

    public Optional<String> getDriveUnit() {
        return Optional.ofNullable(driveUnit);
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }
}
