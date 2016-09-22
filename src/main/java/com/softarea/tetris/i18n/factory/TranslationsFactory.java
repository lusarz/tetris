package com.softarea.tetris.i18n.factory;

import com.softarea.tetris.i18n.EnglishTranslation;
import com.softarea.tetris.i18n.PolishTranslation;
import com.softarea.tetris.i18n.Translation;
import com.softarea.tetris.i18n.exceptions.TranslationNotFoundException;

public class TranslationsFactory {

  public Translation getTranslation(String code) {
    if ("pl".equals(code)) {
      return PolishTranslation.getInstance();
    } else if ("en".equals(code)) {
      return EnglishTranslation.getInstance();
    } else {
      throw new TranslationNotFoundException();
    }
  }
}
