package com.softarea.tetris.drawing.statistics;

import javax.swing.*;

public class StatisticsPanel extends JPanel implements StatisticsView {

    JLabel pointsLabel;

    public StatisticsPanel() {
        super();
        pointsLabel = new JLabel();
        add(pointsLabel);
    }

    public void drawPoints(int points) {
        pointsLabel.setText("" + points);
    }
}
