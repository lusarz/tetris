package com.softarea.tetris.engine.board;

import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.blocks.Block;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int width;
    private int height;
    private DrawingApi drawingApi;

    private Block actualBlock = null;
    private List<BoardRow> rows = new ArrayList<BoardRow>();


    public Board(int width, int height, DrawingApi drawingApi) {
        this.width = width;
        this.height = height;
        this.drawingApi = drawingApi;
        initRows();
    }

    public void draw() {
        drawingApi.drawBoard(this);
    }

    private void initRows() {
        for (int i = 0; i < height; i++) {
            rows.add(new BoardRow(width));
        }
    }
}
