package com.softarea.tetris.engine.board;

public class BoardRow {
    private int width;
    private boolean[] cells;

    public BoardRow(int width) {
        this.width = width;
        cells = new boolean[width];
    }

    public boolean isFilled(int index) {
        return cells[index];
    }

    public void setFilled(int index) {
        cells[index] = true;
    }
}
