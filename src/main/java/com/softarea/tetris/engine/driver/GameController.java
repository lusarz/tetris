package com.softarea.tetris.engine.driver;

import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;
import com.softarea.tetris.engine.listeners.ChangeLevelListener;
import com.softarea.tetris.statistics.Statistics;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final int POINTS_PER_LEVEL = 1000;

    private static final int MAX_LEVEL = 12;

    private Board board;

    private Block block;

    private BlocksQueue queue;

    private DrawingApi drawingApi;

    private Statistics statistics;

    private List<ChangeLevelListener> levelListeners = new ArrayList<ChangeLevelListener>();

    private int level;


    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void init(DrawingApi drawingApi) {
        board = new Board();
        queue = new BlocksQueue();
        block = queue.getNextElement();

        setLevel(4);

        this.drawingApi = drawingApi;

        PlayLoop loop = new PlayLoop();
        Thread thread = new Thread(loop);
        thread.start();
        drawingApi.startDrawing();
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


    private void addPoints(int lines) {
        int pointsBefore = statistics.getPoints();
        statistics.addPoints(lines);
        int pointsAfter = statistics.getPoints();


        if ((pointsBefore / 1000) != (pointsAfter / 1000)) {
            increaseLevel();
        }
    }

    private void increaseLevel() {
        if (getLevel() < MAX_LEVEL) {
            setLevel(getLevel() + 1);
        }
    }


    private class PlayLoop implements Runnable {

        public void run() {
            while (true) {
                block = queue.getNextElement();

                while (true) {
                    try {
                        Thread.sleep(1000 / level);
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


    public void registerChangeLevelListener(ChangeLevelListener listener) {
        levelListeners.add(listener);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;

        for (ChangeLevelListener listener : levelListeners) {
            listener.onChangeLevel(level);
        }
    }
}
