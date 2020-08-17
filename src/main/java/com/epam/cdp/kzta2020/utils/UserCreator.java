package com.epam.cdp.kzta2020.utils;


import com.epam.cdp.kzta2020.business_objects.User;
import com.epam.cdp.kzta2020.common.config.Configuration;

public class UserCreator {
    public static User getUser() {
        final Configuration configuration = ConfigUtil.getConfiguration();
        User user = new User();
        user.setLogin(configuration.getPhoneNumber());
        user.setPassword(configuration.getPassword());
        return user;
    }
}
