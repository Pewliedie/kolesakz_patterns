package com.epam.cdp.kzta2020.common.exeptions;

public class BrowserNotSupportedException extends RuntimeException{
    public BrowserNotSupportedException(String message) {
        super(message);
    }
}
