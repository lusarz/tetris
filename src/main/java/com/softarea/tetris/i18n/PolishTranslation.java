package com.softarea.tetris.i18n;

public class PolishTranslation extends Translation {

  private static PolishTranslation instance = null;

  public static PolishTranslation getInstance() {
    if (instance == null) {
      instance = new PolishTranslation();
    }
    return instance;
  }

  protected void initTranslations() {
    addTranslation("window.title", "Tetris");

        /*Menu game*/
    addTranslation("menu.game.title", "Gra");
    addTranslation("menu.game.description", "Menu zarządzania rozgrywką");
    addTranslation("menu.statistics.title", "Statystyki");
    addTranslation("menu.newGame.title", "Nowa gra");
    addTranslation("menu.game.exit", "Wyjdź");

        /*Menu view**/
    addTranslation("menu.view.title", "Widok");
    addTranslation("menu.view.description", "Menu zarządzania widokiem");

    addTranslation("menu.view.fullScreen.title", "Pełny ekran");
    addTranslation("menu.view.toolbar.title", "Pasek narzędziowy");
    addTranslation("menu.view.statebar.title", "Pasek stanu");


        /*Menu control **/
    addTranslation("menu.control.title", "Sterowanie");
    addTranslation("menu.control.description", "Menu sterowania");
    addTranslation("menu.control.sound", "Dźwięk");

        /* Menu help */
    addTranslation("menu.help.title", "Pomoc");
    addTranslation("menu.help.description", "Menu pomocy");
    addTranslation("menu.help.tableOfContents", "Spis treści");
    addTranslation("menu.help.about", "O programie");
  }

}
