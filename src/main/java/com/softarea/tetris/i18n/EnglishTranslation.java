package com.softarea.tetris.i18n;

public class EnglishTranslation extends Translation {

  private static EnglishTranslation instance = null;

  public static EnglishTranslation getInstance() {
    if (instance == null) {
      instance = new EnglishTranslation();
    }
    return instance;
  }

  protected void initTranslations() {
    addTranslation("window.title", "Tetris");

    addTranslation("menu.game.title", "Game");
    addTranslation("menu.game.description", "This is menu for manage games");
    addTranslation("menu.statistics.title", "Statistics");

    addTranslation("menu.view.title", "View");
    addTranslation("menu.view.description", "View manage");

    addTranslation("menu.view.fullScreen.title", "Full screen");
    addTranslation("menu.view.toolbar.title", "Tool bar");
    addTranslation("menu.view.statebar.title", "Status bar");

    addTranslation("menu.newGame.title", "New game");
  }
}
