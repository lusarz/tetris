package com.softarea.tetris.engine.board;

import com.softarea.tetris.drawing.DrawingApi;

public class Board {
    static int DEFAULT_WIDTH = 10;
    static int DEFAULT_HEIGHT = 20;

    private int width;
    private int height;


    DrawingApi drawingApi;

    boolean[][] actualBlock;

    int actualBlockPositionX;
    int actualBlockPositionY;


    boolean[][] gameCells;

    //private Block actualBlock = null;
    //private List<BoardRow> rows = new ArrayList<BoardRow>();


    public Board(int width, int height, DrawingApi drawingApi) {
        this.width = width;
        this.height = height;
        this.drawingApi = drawingApi;
        gameCells = new boolean[width][height];
    }

    public Board(DrawingApi drawingApi) {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, drawingApi);
    }


    public void draw() {
        drawingApi.drawBoard(this);
    }
}
