package com.softarea.tetris.engine.board;

import com.softarea.tetris.engine.driver.GameDriver;

public class Board {
    static int DEFAULT_WIDTH = 10;
    static int DEFAULT_HEIGHT = 20;

    int width;
    int height;

    GameDriver gameDriver;

    boolean[][] gameCells;


    public Board(int width, int height, GameDriver gameDriver) {
        this.width = width;
        this.height = height;
        this.gameDriver = gameDriver;
        gameCells = new boolean[width][height];
    }

    public Board(GameDriver gameDriver) {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, gameDriver);
    }


    public void saveBlock(BlockOnBoard actualBlock) {
    }


    public boolean checkCollision(BlockOnBoard actualBlock) {
        return false;
    }

    public boolean isGameOver() {
        return false;
    }

    public int clearFullLines() {
        return 0;
    }
}
