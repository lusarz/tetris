package com.softarea.tetris.engine.driver;

import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;

public class MovementsController {

    private Board board;

    private Block block;

    int positionX;

    int positionY;

    int rotation;


    public void moveDown() {
        boolean[][] block = resolveBlock();

        if (board.hasCollision(positionX, positionY + 1, block)) {
            board.saveBlock(positionX, positionY, block);
            int lines = board.removeFullLines();
            //TODO: add points for line remove
            if (board.checkGameOver()) {
                //TODO: do game over
            }
        } else {
            positionY++;
        }
        //TODO: draw after this
    }


    public void moveLeft() {
        boolean[][] block = resolveBlock();

        if (!board.hasCollision(positionX - 1, positionY, block)) {
            positionX--;
            //TODO: draw after this
        }
    }

    public void moveRight() {
        boolean[][] block = resolveBlock();

        if (!board.hasCollision(positionX + 1, positionY, block)) {
            positionX++;
            //TODO: draw after this
        }
    }

    public void rotateLeft() {
        rotation--;
        boolean[][] rotatedBlock = resolveBlock();
        if (board.hasCollision(positionX, positionY, rotatedBlock)) {
            rotation++;
        } else {
            //TODO: draw after this
        }
    }

    public void rotateRight() {
        rotation++;
        boolean[][] rotatedBlock = resolveBlock();
        if (board.hasCollision(positionX, positionY, rotatedBlock)) {
            rotation--;
        } else {
            //TODO: draw after this
        }
    }

    private boolean[][] resolveBlock() {
        if (rotation < 1) {
            rotation = 4;
        } else if (rotation > 4) {
            rotation = 0;
        }
        switch (rotation) {
            case 1:
                return block.get0Rotation();
            case 2:
                return block.get90Rotation();
            case 3:
                return block.get180Rotation();
            case 4:
                return block.get270Rotation();
            default:
                return block.get0Rotation();
        }
    }
}
