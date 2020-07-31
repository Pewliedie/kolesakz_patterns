package com.epam.cdp.kzta2020.domain;

public class CarSearchTermFactory {
    public static CarSearchTerm getAdvancedSearchCarTerm(){
        CarSearchTerm carSearchTerm = new CarSearchTerm();
        carSearchTerm.setPrice("110000000");
        carSearchTerm.setCountry("Англия");
        carSearchTerm.setCarStatus("На ходу");
        carSearchTerm.setBodyType("седан");
        carSearchTerm.setEngineType("бензин");
        carSearchTerm.setLocationOfWheel("слева");
        carSearchTerm.setDriveUnit("полный привод");
        carSearchTerm.setEngineVolumeFrom("5.5");
        carSearchTerm.setEngineVolumeTo("6.7");
        carSearchTerm.setEngineVolumeAndType("6 (бензин)");
        return carSearchTerm;
    }

    public static CarSearchTerm getSearchWithPhotoCarTerm(){
        CarSearchTerm carSearchTerm = new CarSearchTerm();
        carSearchTerm.setPrice("60000000");
        carSearchTerm.setModelYear("2020");
        return carSearchTerm;
    }

    public static CarSearchTerm getPublishAdTerm(){
        CarSearchTerm carSearchTerm = new CarSearchTerm();
        carSearchTerm.setPrice("10000000");
        return carSearchTerm;
    }

}
