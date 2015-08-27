package com.softarea.tetris.i18n.exceptions;

public class TranslationNotFoundException extends RuntimeException {
    public TranslationNotFoundException() {
        super("Translation with this name not found");
    }
}
