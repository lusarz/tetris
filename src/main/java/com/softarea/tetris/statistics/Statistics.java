package com.softarea.tetris.statistics;

import com.softarea.tetris.drawing.statistics.StatisticsView;

public class Statistics {

  private StatisticsView statisticsView;

  private int points = 0;

  public void addPoints(int numberOfLines) {
    switch (numberOfLines) {
      case 1:
        points += 100;
        break;
      case 2:
        points += 200;
        break;
      case 3:
        points += 500;
        break;
      case 4:
        points += 1000;
        break;
      default:
        break;

    }

    if (statisticsView != null) {
      statisticsView.drawPoints(points);
    }
  }

  public int getPoints() {
    return points;
  }

  public void setStatisticsView(StatisticsView statisticsView) {
    this.statisticsView = statisticsView;
    statisticsView.drawPoints(points);
  }
}
