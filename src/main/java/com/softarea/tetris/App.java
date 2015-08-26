package com.softarea.tetris;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 */
public class App extends JFrame {

    public App() {
        initUI();
    }

    private void initUI() {

        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                App application = new App();
                application.setVisible(true);
            }
        });
    }
}