package com.softarea.tetris.engine.board;

public class Board {
    static int DEFAULT_WIDTH = 10;
    static int DEFAULT_HEIGHT = 20;

    int width;
    int height;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    
}
