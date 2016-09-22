package com.softarea.tetris.engine.blocks;

public interface Block {
  void moveDown();

  void moveLeft();

  void moveRight();

  void rotateRight();

  void rotateLeft();

  int getWidth();

  int getHeight();

  int getField(int x, int y);

  int getX();

  int getY();

  BlockMemento save();

  void undo(BlockMemento memento);

  class BlockMemento {
    protected int x;
    protected int y;
    protected int actualRotation;

    public BlockMemento(int x, int y, int actualRotation) {
      this.x = x;
      this.y = y;
      this.actualRotation = actualRotation;
    }
  }
}
