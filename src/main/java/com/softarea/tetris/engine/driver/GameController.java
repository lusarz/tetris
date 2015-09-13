package com.softarea.tetris.engine.driver;

import com.softarea.tetris.drawing.DrawingApi;
import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;

public class GameController {

    private Board board;

    private Block block;

    private BlocksQueue queue;

    private DrawingApi drawingApi;


    public boolean moveDownOrSave() {
        Block.BlockMemento memento = block.save();
        block.moveDown();
        if (board.checkCollision(block)) {
            block.undo(memento);
            board.saveBlock(block);
            return true;
        }
        return false;
    }

    public void tryMoveRight() {
        Block.BlockMemento memento = block.save();
        block.moveRight();
        if (board.checkCollision(block)) {
            block.undo(memento);
        }
    }

    public void tryMoveLeft() {
        Block.BlockMemento memento = block.save();

        block.moveLeft();
        if (board.checkCollision(block)) {
            block.undo(memento);
        }
    }


    public void playLoop() throws InterruptedException {
        while (true) {
            block = queue.getNextElement();

            while (true) {
                Thread.sleep(1000);
                boolean saved = moveDownOrSave();
                if (saved) {
                    int lines = board.removeFullLines();
                    addPoints(lines);
                    break;
                }
            }
            if (board.isGameOver()) {
                break;
            }
        }
    }

    private void addPoints(int lines) {

    }

}
