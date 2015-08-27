package com.softarea.tetris.i18n;

import java.util.Properties;

public abstract class Translation implements Translateable {
    private Properties translations = new Properties();

    public String translate(String key) {
        return translations.getProperty(key);
    }

    protected Translation() {
        initTranslations();
    }

    protected void addTranslation(String code, String value) {
        translations.put(code, value);
    }

    protected abstract void initTranslations();
}
