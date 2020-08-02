package com.epam.cdp.kzta2020.domain;

public class KolesaTestTermFactory {
    public static KolesaTestTerm getAdvancedSearchCarTerm(){
        KolesaTestTerm kolesaTestTerm = new KolesaTestTerm();
        kolesaTestTerm.setPrice("110000000");
        kolesaTestTerm.setCountry("Англия");
        kolesaTestTerm.setCarStatus("На ходу");
        kolesaTestTerm.setBodyType("седан");
        kolesaTestTerm.setEngineType("бензин");
        kolesaTestTerm.setLocationOfWheel("слева");
        kolesaTestTerm.setDriveUnit("полный привод");
        kolesaTestTerm.setEngineVolumeFrom("5.5");
        kolesaTestTerm.setEngineVolumeTo("6.7");
        kolesaTestTerm.setEngineVolumeAndType("6 (бензин)");
        return kolesaTestTerm;
    }

    public static KolesaTestTerm getSearchWithPhotoCarTerm(){
        KolesaTestTerm kolesaTestTerm = new KolesaTestTerm();
        kolesaTestTerm.setPrice("60000000");
        kolesaTestTerm.setModelYear("2020");
        return kolesaTestTerm;
    }

    public static KolesaTestTerm getPublishAdTerm(){
        KolesaTestTerm kolesaTestTerm = new KolesaTestTerm();
        kolesaTestTerm.setPrice("10000000");
        return kolesaTestTerm;
    }

}
