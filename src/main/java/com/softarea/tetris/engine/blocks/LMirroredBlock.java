package com.softarea.tetris.engine.blocks;

public class LMirroredBlock extends Block {
    private static final boolean[][][] ROTATES = new boolean[0][][];

    @Override
    public boolean[][][] getRotates() {
        return ROTATES;
    }

    @Override
    public int getRotatesLength() {
        return ROTATES.length;
    }
}
