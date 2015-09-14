package com.softarea.tetris.engine.blocks;

public abstract class AbstractBlock implements Block {

    private int actualRotation = 0;

    //Block top left x position
    private int x;

    //Block top left y position
    private int y = 0;


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

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
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
        return cellsForCurrentRotation().length;
    }

    public int getHeight() {
        return cellsForCurrentRotation()[0].length;
    }

    public int getField(int x, int y) {
        int[][] cells = cellsForCurrentRotation();
        return cells[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
