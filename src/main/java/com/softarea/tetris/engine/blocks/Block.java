package com.softarea.tetris.engine.blocks;

public abstract class Block {

    public static final int DEFAULT_SIZE = 4;

    public abstract boolean[][][] getRotates();

    public abstract int getRotatesLength();
}
