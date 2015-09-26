package com.softarea.tetris.drawing.statistics;

import com.softarea.tetris.engine.driver.GameController;
import com.softarea.tetris.engine.listeners.ChangeLevelListener;

import javax.swing.*;

public class StatisticsPanel extends JPanel implements StatisticsView, ChangeLevelListener {

    private GameController gameController;

    private JLabel pointsLabel;
    private JLabel levelLabel;

    public StatisticsPanel(GameController gameController) {
        super();
        this.gameController = gameController;

        pointsLabel = new JLabel();
        levelLabel = new JLabel();

        add(pointsLabel);
        add(levelLabel);

    }

    public void drawPoints(int points) {
        pointsLabel.setText("Points: " + points);
    }

    public void onChangeLevel(int level) {
        levelLabel.setText("Level: " + level);
    }
}
