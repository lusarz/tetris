package com.softarea.tetris;

import com.softarea.tetris.drawing.BoardPanel;
import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.drawing.statistics.StatisticsInConsoleView;
import com.softarea.tetris.engine.driver.GameController;
import com.softarea.tetris.i18n.factory.TranslationsFactory;
import com.softarea.tetris.menu.MainMenuBar;
import com.softarea.tetris.statistics.Statistics;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame {

    ApplicationContext context;

    DrawingApi drawingApi;

    GameController gameController;

    Statistics statistics;


    public MainWindow() {
        initApplicationContext();
        initGame();
        initUI();
        setJMenuBar(new MainMenuBar());
    }

    private void initGame() {
        BoardPanel panel = new BoardPanel();

        drawingApi = panel;
        gameController = new GameController();
        gameController.init(drawingApi);
        statistics = new Statistics();

        //StatisticsPanel statisticsPanel = new StatisticsPanel();
        statistics.setStatisticsView(new StatisticsInConsoleView());

        gameController.setStatistics(statistics);
        add(panel);
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
        setSize(300, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private String translate(String key) {
        return context.getTranslation().translate(key);
    }

}
