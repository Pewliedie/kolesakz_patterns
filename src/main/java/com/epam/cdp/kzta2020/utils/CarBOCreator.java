package com.epam.cdp.kzta2020.utils;


import com.epam.cdp.kzta2020.business_objects.Car;

public class CarBOCreator {
    public static Car createCar(String location,String priceFrom,String priceTo,String mark,String model) {
        Car car = new Car();
        car.setLocation(location);
        car.setPriceFrom(priceFrom);
        car.setPriceTo(priceTo);
        car.setMark(mark);
        car.setModel(model);
        return car;
    }
}

