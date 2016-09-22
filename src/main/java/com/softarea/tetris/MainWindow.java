package com.softarea.tetris;

import com.softarea.tetris.drawing.BoardPanel;
import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.drawing.statistics.StatisticsPanel;
import com.softarea.tetris.engine.driver.GameController;
import com.softarea.tetris.i18n.factory.TranslationsFactory;
import com.softarea.tetris.menu.MainMenuBar;
import com.softarea.tetris.statistics.Statistics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame {

  private ApplicationContext context;

  private DrawingApi drawingApi;

  private GameController gameController;

  private Statistics statistics;

  private StatisticsPanel statisticsPanel;


  public MainWindow() {
    setLayout(new GridLayout(1, 0));
    setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    initApplicationContext();
    initGame();
    initUI();
    setJMenuBar(new MainMenuBar());
  }

  private void initGame() {
    BoardPanel panel = new BoardPanel();

    drawingApi = panel;
    gameController = new GameController();
    statistics = new Statistics();
    statisticsPanel = new StatisticsPanel(gameController);

    //StatisticsPanel statisticsPanel = new StatisticsPanel();
    statistics.setStatisticsView(statisticsPanel);

    gameController.setStatistics(statistics);
    gameController.registerChangeLevelListener(statisticsPanel);

    add(panel);
    add(statisticsPanel);
    gameController.init(drawingApi);
    //       add(statisticsPanel);
    addKeyListener(new KeyListener() {
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
          gameController.tryMoveLeft();
        } else if (e.getKeyChar() == 'd') {
          gameController.tryMoveRight();
        } else if (e.getKeyChar() == 's') {
          gameController.moveDownOrSave();
        } else if (e.getKeyChar() == 'p') {
          gameController.tryRotateLeft();
        } else if (e.getKeyChar() == 'o') {
          gameController.tryRotateRight();
        }
      }

      public void keyPressed(KeyEvent e) {

      }

      public void keyReleased(KeyEvent e) {

      }
    });
  }

  private void initApplicationContext() {
    context = ApplicationContext.getInstance();
    context.setTranslation(new TranslationsFactory().getTranslation("pl"));
    context.setMainWindow(this);
  }


  private void initUI() {
    setTitle(translate("window.title"));
    setSize(640, 480);
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private String translate(String key) {
    return context.getTranslation().translate(key);
  }

}
