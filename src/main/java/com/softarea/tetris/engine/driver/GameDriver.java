package com.softarea.tetris.engine.driver;

import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.board.Board;

public class GameDriver {
    private Board board;
    private DrawingApi drawingApi;
    private BlocksQueue blocksQueue;


    public GameDriver(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
        this.board = new Board();
        blocksQueue = new BlocksQueue();
    }

    public void startGame() {
    }


    public void pauseGame() {

    }

    private void doGameOver() {

    }
}
