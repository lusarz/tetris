package com.softarea.tetris.engine.blocks;

public abstract class AbstractBlock implements Block {

    private int actualRotation = 0;

    //Block top left x position
    private int x;

    //Block top left y position
    private int y;


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

    public BlockMemento save() {
        return new BlockMemento(x, y, actualRotation);
    }

    public void undo(BlockMemento memento) {
        this.x = memento.x;
        this.y = memento.y;
        this.actualRotation = memento.actualRotation;
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public int getField(int x, int y) {
        return 0;
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
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
