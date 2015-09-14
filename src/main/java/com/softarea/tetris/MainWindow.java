package com.softarea.tetris;

import com.softarea.tetris.drawing.BoardPanel;
import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.driver.GameController;
import com.softarea.tetris.i18n.factory.TranslationsFactory;
import com.softarea.tetris.menu.MainMenuBar;

import javax.swing.*;

public class MainWindow extends JFrame {

    ApplicationContext context;

    DrawingApi drawingApi;

    GameController gameController;


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
        add(panel);

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
