package com.softarea.tetris;

import com.softarea.tetris.configuration.AppConfiguration;

public class ApplicationContext extends AppConfiguration {

  private static ApplicationContext instance = new ApplicationContext();
  private MainWindow mainWindow;


  private ApplicationContext() {
  }

  public static ApplicationContext getInstance() {
    return instance;
  }

  public void setMainWindow(MainWindow mainWindow) {
    this.mainWindow = mainWindow;
  }

  public MainWindow getMainWindow() {
    return mainWindow;
  }
}
