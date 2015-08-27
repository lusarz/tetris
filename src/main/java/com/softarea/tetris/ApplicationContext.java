package com.softarea.tetris;

import com.softarea.tetris.configuration.AppConfiguration;

public class ApplicationContext extends AppConfiguration {

    private static ApplicationContext instance = new ApplicationContext();


    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        return instance;
    }
}
