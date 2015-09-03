package com.softarea.tetris.engine.blocks;

public class LBlock extends Block {
    private static final boolean[][][] ROTATES = new boolean[][][]{
            {
                    {false, false, true, false},
                    {false, false, true, false},
                    {false, true, true, false},
                    {false, false, false, false}
            },
            {
                    {false, false, false, false},
                    {false, true, false, false},
                    {false, true, true, true},
                    {false, false, false, false}
            },
            {
                    {false, false, true, true},
                    {false, false, true, false},
                    {false, false, true, false},
                    {false, false, false, false}
            },
            {
                    {false, false, false, false},
                    {false, true, true, true},
                    {false, true, false, false},
                    {false, false, false, false}
            }
    };

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
