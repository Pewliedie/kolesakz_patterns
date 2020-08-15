package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.business_objects.Car;

public class CarBOCreator {
    public static Car createCar() {
        Car car = new Car();
        car.setCity("Алматы");
        car.setPriceFrom("5 000 000 ₸");
        car.setPriceTo("5 000 000 ₸");
        car.setMark("toyota");
        car.setModel("camry");
        return car;
    }
}
