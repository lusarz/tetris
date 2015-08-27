package com.softarea.tetris;

import com.softarea.tetris.i18n.factory.TranslationsFactory;
import com.softarea.tetris.menu.MainMenuBar;

import javax.swing.*;

public class MainWindow extends JFrame {

    ApplicationContext context;

    public MainWindow() {
        initApplicationContext();
        initUI();
        setJMenuBar(new MainMenuBar());
    }

    private void initApplicationContext() {
        context = ApplicationContext.getInstance();
        context.setTranslation(new TranslationsFactory().getTranslation("pl"));
        context.setMainWindow(this);
    }


    private void initUI() {
        setTitle(translate("window.title"));
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private String translate(String key) {
        return context.getTranslation().translate(key);
    }
}
