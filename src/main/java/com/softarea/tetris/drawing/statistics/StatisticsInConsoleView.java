package com.softarea.tetris.drawing.statistics;

public class StatisticsInConsoleView implements StatisticsView {
  public void drawPoints(int points) {
    System.out.println("Points: " + points);
  }
}
