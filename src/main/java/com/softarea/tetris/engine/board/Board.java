package com.softarea.tetris.engine.board;

import com.softarea.tetris.engine.blocks.Block;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static int DEFAULT_WIDTH = 10;
    private static int DEFAULT_HEIGHT = 20;

    private int width;
    private int height;

    private List<int[]> blocks;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        blocks = new ArrayList<int[]>();
        for (int i = 0; i < height; i++) {
            blocks.add(new int[width]);
        }
    }

    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


    public boolean checkCollision(Block block) {
        return (checkBorderCollision(block) || checkPointsCollision(block));
    }


    public void saveBlock(Block block) {
        for (int i = 0; i < block.getWidth(); i++) {
            for (int j = 0; j < block.getHeight(); j++) {
                setField(block.getX() + i, block.getY() + j, block.getField(i, j));
            }
        }
    }

    public int removeFullLines() {
        int linesCount = 0;

        for (int j = 0; j < height; j++) {
            if (isLineFull(j)) {
                linesCount++;
                removeLine(j);
            }
        }
        return linesCount;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getField(int x, int y) {
        return blocks.get(y)[x];
    }

    private boolean checkBorderCollision(Block block) {
        boolean isLeftCollision = (block.getX() < 0);
        boolean isRightCollision = (block.getX() + block.getWidth() > width);
        boolean isDownCollision = (block.getY() + block.getHeight() > height);

        return (isLeftCollision || isRightCollision || isDownCollision);
    }

    private boolean checkPointsCollision(Block block) {
        for (int i = 0; i < block.getWidth(); i++) {
            for (int j = 0; j < block.getHeight(); j++) {
                int blockValue = block.getField(i, j);
                int boardValue = getField(block.getX() + i, block.getY() + j);

                if ((blockValue > 0) && (boardValue > 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void removeLine(int lineNumber) {
        blocks.remove(lineNumber);
        blocks.add(0, new int[getWidth()]);
    }

    private boolean isLineFull(int lineNumber) {
        boolean lineFull = true;
        for (int i = 0; i < width; i++) {
            int fieldValue = getField(i, lineNumber);
            if (fieldValue == 0) {
                lineFull = false;
                break;
            }
        }
        return lineFull;
    }

    private void setField(int x, int y, int value) {
        blocks.get(y)[x] = value;
    }


    public boolean isGameOver() {
        //TODO: implement this
        return false;
    }
}
