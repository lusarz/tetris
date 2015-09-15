package com.softarea.tetris.engine.driver;

import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;
import com.softarea.tetris.statistics.Statistics;

public class GameController {

    private Board board;

    private Block block;

    private BlocksQueue queue;

    private DrawingApi drawingApi;

    private Statistics statistics;


    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void init(DrawingApi drawingApi) {
        board = new Board();
        queue = new BlocksQueue();
        block = queue.getNextElement();

        this.drawingApi = drawingApi;

        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.println("Uncaught exception: ");
                ex.printStackTrace();
            }
        };

        Thread thread = new Thread(new PlayLoop());
        thread.setUncaughtExceptionHandler(h);
        thread.start();
    }

    public boolean moveDownOrSave() {
        Block.BlockMemento memento = block.save();
        block.moveDown();
        if (board.checkCollision(block)) {
            block.undo(memento);
            board.saveBlock(block);
            return true;
        } else {
            drawGame();
        }
        return false;
    }

    private void drawGame() {
        drawingApi.drawGame(block, board);
    }

    public void tryMoveRight() {
        Block.BlockMemento memento = block.save();
        block.moveRight();
        redrawOrUndoIfCollide(memento);
    }


    public void tryMoveLeft() {
        Block.BlockMemento memento = block.save();

        block.moveLeft();
        redrawOrUndoIfCollide(memento);
    }

    public void tryRotateLeft() {
        Block.BlockMemento memento = block.save();

        block.rotateLeft();
        redrawOrUndoIfCollide(memento);
    }

    public void tryRotateRight() {
        Block.BlockMemento memento = block.save();

        block.rotateRight();
        redrawOrUndoIfCollide(memento);
    }

    private void redrawOrUndoIfCollide(Block.BlockMemento memento) {
        if (board.checkCollision(block)) {
            block.undo(memento);
        } else {
            drawGame();
        }
    }


    public void playLoop() {

    }

    private void addPoints(int lines) {
        statistics.addPoints(lines);
    }

    private class PlayLoop implements Runnable {

        public void run() {
            while (true) {
                block = queue.getNextElement();

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    boolean saved = moveDownOrSave();
                    if (saved) {
                        int lines = board.removeFullLines();
                        if (lines > 0) {
                            addPoints(lines);
                        }
                        break;
                    }
                }
                if (board.isGameOver()) {
                    break;
                }
            }
        }
    }

}
