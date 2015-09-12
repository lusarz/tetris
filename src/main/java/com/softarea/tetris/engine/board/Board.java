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
        int blockHeight = block.getHeight();
        int blockWidth = block.getWidth();
        int blockX = block.getX();
        int blockY = block.getY();


        if ((blockX < 0) || (blockX + blockWidth > width) || blockY + blockHeight > height) {
            return true;
        } else {
            for (int i = 0; i < blockWidth; i++) {
                for (int j = 0; j < blockHeight; j++) {
                    int blockValue = block.getField(i, j);
                    int boardValue = getField(blockX + i, blockY + j);

                    if ((blockValue > 0) && (boardValue > 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int getField(int x, int y) {

        return blocks.get(y)[x];
    }

    private void setField(int x, int y, int value) {
        blocks.get(y)[x] = value;
    }


}
