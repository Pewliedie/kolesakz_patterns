package com.epam.cdp.kzta2020.business_objects;

import com.epam.cdp.kzta2020.common.config.ConfigReader;
import com.epam.cdp.kzta2020.common.config.Configuration;

public class KolesakzUser {
    private final Configuration configuration = ConfigReader.getConfiguration();
    private String login = configuration.getPhoneNumber();
    private String password = configuration.getPassword();

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
