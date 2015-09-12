package com.softarea.tetris.engine.blocks;

public class ZBlock extends AbstractBlock {
    private static final int[][][] ROTATES = new int[0][][];

    @Override
    public int[][] get0Rotation() {
        return ROTATES[0];
    }

    @Override
    public int[][] get90Rotation() {
        return ROTATES[0];
    }

    @Override
    public int[][] get180Rotation() {
        return ROTATES[0];
    }

    @Override
    public int[][] get270Rotation() {
        return ROTATES[0];
    }
}
