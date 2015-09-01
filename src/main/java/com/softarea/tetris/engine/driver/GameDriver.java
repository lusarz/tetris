package com.softarea.tetris.engine.driver;

import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.board.BlockOnBoard;
import com.softarea.tetris.engine.board.Board;

public class GameDriver {
    private Board board;
    private DrawingApi drawingApi;
    private BlocksQueue blocksQueue;

    private BlockOnBoard actualBlock;


    public GameDriver(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
        this.board = new Board(this);
        blocksQueue = new BlocksQueue();
    }

    public void startGame() {
        actualBlock = new BlockOnBoard(blocksQueue.getNextElement(), board);
        drawingApi.drawBoard(actualBlock, board);
    }


    public void pauseGame() {

    }

    public void moveDown() {
        actualBlock.saveState();
        actualBlock.moveDown();
        if (board.checkCollision(actualBlock)) {
            actualBlock.restoreState();
            board.saveBlock(actualBlock);
            int lines = board.clearFullLines();
            if (board.isGameOver()) {
                doGameOver();
            } else {

            }
        }
    }

    private void doGameOver() {

    }
}
