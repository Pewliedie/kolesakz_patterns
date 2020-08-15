package com.epam.cdp.kzta2020.domain;

public class KolesaDataFactory {
    public static KolesaAdvancedSearchData getAdvancedSearchData(){
        KolesaAdvancedSearchData kolesaAdvancedSearchData = new KolesaAdvancedSearchData();
        kolesaAdvancedSearchData.setCity("almaty");
        kolesaAdvancedSearchData.setPrice("110000000");
        kolesaAdvancedSearchData.setCountry("Англия");
        kolesaAdvancedSearchData.setVehicleStatus("На ходу");
        kolesaAdvancedSearchData.setBodyType("седан");
        kolesaAdvancedSearchData.setEngineType("бензин");
        kolesaAdvancedSearchData.setLocationOfWheel("слева");
        kolesaAdvancedSearchData.setDriveUnit("полный привод");
        kolesaAdvancedSearchData.setEngineVolumeFrom("5.5");
        kolesaAdvancedSearchData.setEngineVolumeTo("6.7");
        kolesaAdvancedSearchData.setEngineVolumeAndType("6 (бензин)");
        return kolesaAdvancedSearchData;
    }

    public static KolesaSearchWithPhotoData getSearchWithPhotoCarData(){
        KolesaSearchWithPhotoData kolesaSearchWithPhotoData = new KolesaSearchWithPhotoData();
        kolesaSearchWithPhotoData.setCity("karaganda");
        kolesaSearchWithPhotoData.setPrice("60000000");
        kolesaSearchWithPhotoData.setModelYear("2020");
        kolesaSearchWithPhotoData.setMark("bmw");
        return kolesaSearchWithPhotoData;
    }

    public static KolesaPostAdData getPublishAdTermData(){
        KolesaPostAdData kolesaPostAdData = new KolesaPostAdData();
        kolesaPostAdData.setPrice("10000000");
        kolesaPostAdData.setCategory1("Машины");
        kolesaPostAdData.setCategory2("Легковые");
        kolesaPostAdData.setMark("Toyota");
        kolesaPostAdData.setModel("Camry");
        kolesaPostAdData.setModelYear("2015");
        kolesaPostAdData.setEngineType("Бензиновый");
        kolesaPostAdData.setEngineModification("2.5");
        kolesaPostAdData.setCity("Караганда");
        kolesaPostAdData.setEmail("qqq@com.com");
        return kolesaPostAdData;
    }

}
