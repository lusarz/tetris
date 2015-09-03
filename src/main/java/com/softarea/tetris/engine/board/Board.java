package com.softarea.tetris.engine.board;

public class Board {
    static int DEFAULT_WIDTH = 10;
    static int DEFAULT_HEIGHT = 20;

    int width;
    int height;


    boolean[][] gameCells;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        gameCells = new boolean[width][height];
    }

    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


    public void saveBlock(int x, int y, boolean[][] block) {
        //TODO: implement this
    }


    public boolean hasCollision(int x, int y, boolean[][] block) {
        //TODO: implement this
        return false;
    }

    public boolean checkGameOver() {
        //TODO: implement this
        return false;
    }

    public int removeFullLines() {
        //TODO: implement this
        return 0;
    }
}
