package com.epam.cdp.kzta2020.domain;

public class DataFactory {
    public static AdvancedSearchData getAdvancedSearchData(){
        AdvancedSearchData advancedSearchData = new AdvancedSearchData();
        advancedSearchData.setCity("Алматы");
        advancedSearchData.setPriceFrom("110000000");
        advancedSearchData.setCountry("Англия");
        advancedSearchData.setVehicleStatus("На ходу");
        advancedSearchData.setBodyType("седан");
        advancedSearchData.setEngineType("бензин");
        advancedSearchData.setLocationOfWheel("слева");
        advancedSearchData.setDriveUnit("полный привод");
        advancedSearchData.setEngineVolumeFrom("5.5");
        advancedSearchData.setEngineVolumeTo("6.7");
        advancedSearchData.setEngineVolumeAndType("6 (бензин)");
        return advancedSearchData;
    }

    public static SearchWithPhotoData getSearchWithPhotoCarData(){
        SearchWithPhotoData kolesaSearchWithPhotoData = new SearchWithPhotoData();
        kolesaSearchWithPhotoData.setCity("karaganda");
        kolesaSearchWithPhotoData.setPriceFrom("60000000");
        kolesaSearchWithPhotoData.setModelYear("2020");
        kolesaSearchWithPhotoData.setMark("bmw");
        return kolesaSearchWithPhotoData;
    }

    public static PostAdData getPublishAdData(){
        PostAdData kolesaPostAdData = new PostAdData();
        kolesaPostAdData.setPriceFrom("10000000");
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
