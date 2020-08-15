package com.epam.cdp.kzta2020.business_objects;

import com.epam.cdp.kzta2020.common.config.ConfigReader;
import com.epam.cdp.kzta2020.common.config.Configuration;

public class KolesakzUser {
    private final Configuration configuration = ConfigReader.getConfiguration();
    private final String login = configuration.getPhoneNumber();
    private final String password = configuration.getPassword();

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
