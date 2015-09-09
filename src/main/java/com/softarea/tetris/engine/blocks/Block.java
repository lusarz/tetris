package com.softarea.tetris.engine.blocks;

import com.softarea.tetris.engine.blocks.support.Position;

public abstract class Block {

    private int actualRotation = 0;

    private Position topLeftPosition;

    private Position potentialTopLeftPosition;

    public Position getTopLeftPosition() {
        return topLeftPosition;
    }

    public void setTopLeftPosition(Position topLeftPosition) {
        this.topLeftPosition = topLeftPosition;
    }

    public Position getPotentialTopLeftPosition() {
        return potentialTopLeftPosition;
    }

    public void setPotentialTopLeftPosition(Position potentialTopLeftPosition) {
        this.potentialTopLeftPosition = potentialTopLeftPosition;
    }

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

    public int[][] cellsForCurrentRotation() {
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

    public abstract int[][] get0Rotation();

    public abstract int[][] get90Rotation();

    public abstract int[][] get180Rotation();

    public abstract int[][] get270Rotation();
}
