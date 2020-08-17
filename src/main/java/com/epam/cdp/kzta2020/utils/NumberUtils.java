package com.epam.cdp.kzta2020.utils;

import java.util.Optional;

public class NumberUtils {
    public static int convertToInt(Optional<String> optional){
        return Integer.parseInt(optional.toString()
                .replace("₸","")
                .replace("Optional","")
                .replace("[","")
                .replace("]","")
                .replaceAll("\\s+",""));
    }

    public static int convertToInt(String s){
        return Integer.parseInt(s
                .replace("₸","")
                .replace("Optional","")
                .replace("[","")
                .replace("]","")
                .replaceAll("\\s+",""));
    }
}
