package com.epam.cdp.kzta2020.utils;

import java.util.Random;

public class RandomNumberGenerator {
    public static String generateNumber(){
        return String.valueOf(new Random().nextInt(20));
    }
}
