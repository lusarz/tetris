package com.softarea.tetris.engine.blocks;

public abstract class Block {


    public static final int DEFAULT_SIZE = 4;

    public int actualRotation = 0;

    public void rotateRight() {
        if (actualRotation == 3) {
            actualRotation = 0;
        } else {
            actualRotation++;
        }
    }

    public void rotateLeft() {
        if (actualRotation == 0) {
            actualRotation = 3;
        } else {
            actualRotation--;
        }
    }

    public boolean[][] getActualRotation() {
        switch (actualRotation) {
            case 1:
                return get0Rotation();
            case 2:
                return get90Rotation();
            case 3:
                return get180Rotation();
            case 4:
                return get270Rotation();
            default:
                return get0Rotation();
        }
    }

    public abstract boolean[][] get0Rotation();

    public abstract boolean[][] get90Rotation();

    public abstract boolean[][] get180Rotation();

    public abstract boolean[][] get270Rotation();
}
