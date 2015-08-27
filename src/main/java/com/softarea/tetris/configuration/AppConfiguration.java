package com.softarea.tetris.configuration;

import com.softarea.tetris.i18n.Translation;

public abstract class AppConfiguration {
    private Translation translation;

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }
}
