package com.softarea.tetris.engine.board;

import com.softarea.tetris.engine.blocks.Block;

public class BlockOnBoard {
    int positionX;
    int positionY;

    protected int actualRotate;
    protected int rotatesCount;

    Block block;

    BlockOnBoardMemento memento;


    public BlockOnBoard(Block block, Board board) {
        positionY = 0;
        positionX = (board.width - Block.DEFAULT_SIZE) / 2;
        this.block = block;
        this.actualRotate = 0;
        this.rotatesCount = block.getRotatesLength();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void moveDown() {
        positionY++;
    }

    public void moveLeft() {
        positionY--;
    }

    public void moveRight() {
        positionY++;
    }

    public boolean rotateLeft() {
        if (rotateAvailable()) {
            actualRotate = getPreviousRotation(actualRotate, block.getRotatesLength());
            return true;
        }
        return false;
    }

    public boolean rotateRight() {
        if (rotateAvailable()) {
            actualRotate = getNextRotation(actualRotate, block.getRotatesLength());
            return true;
        }
        return false;
    }

    public boolean[][] getBooleanMap() {
        return block.getRotates()[actualRotate];
    }

    private boolean rotateAvailable() {
        return (block.getRotatesLength() > 1);
    }

    int getPreviousRotation(int actualRotate, int rotatesCount) {
        if (actualRotate < 1) {
            return rotatesCount - 1;
        } else {
            return actualRotate - 1;
        }
    }

    int getNextRotation(int actualRotate, int rotatesLength) {
        if (actualRotate == rotatesLength - 1) {
            return 0;
        } else {
            return actualRotate - 1;
        }
    }

    public Block getBlock() {
        return block;
    }

    public void restoreState() {
        if (memento != null) {
            positionX = memento.getPositionX();
            positionY = memento.getPositionY();
            actualRotate = memento.getActualRotate();
        }
    }

    public void saveState() {
        memento = new BlockOnBoardMemento(positionX, positionY, actualRotate);
    }


    private class BlockOnBoardMemento {
        int positionX;
        int positionY;

        protected int actualRotate;

        public BlockOnBoardMemento(int positionX, int positionY, int actualRotate) {
            this.positionX = positionX;
            this.positionY = positionY;
            this.actualRotate = actualRotate;
        }

        public int getPositionX() {
            return positionX;
        }

        public int getPositionY() {
            return positionY;
        }

        public int getActualRotate() {
            return actualRotate;
        }
    }
}
