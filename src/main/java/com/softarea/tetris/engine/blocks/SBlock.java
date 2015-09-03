package com.softarea.tetris.engine.blocks;

public class SBlock extends Block {
    private static final boolean[][][] ROTATES = new boolean[0][][];

    @Override
    public boolean[][] get0Rotation() {
        return ROTATES[0];
    }

    @Override
    public boolean[][] get90Rotation() {
        return ROTATES[0];
    }

    @Override
    public boolean[][] get180Rotation() {
        return ROTATES[0];
    }

    @Override
    public boolean[][] get270Rotation() {
        return ROTATES[0];
    }
}
