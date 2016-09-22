package com.softarea.tetris.engine.blocks;

public class StraightBlock extends AbstractBlock {
  private static final int[][][] ROTATES = new int[][][]{
      {
          {1, 1, 1, 1}
      },
      {
          {1},
          {1},
          {1},
          {1}
      }
  };

  @Override
  public int[][] get0Rotation() {
    return ROTATES[0];
  }

  @Override
  public int[][] get90Rotation() {
    return ROTATES[1];
  }

  @Override
  public int[][] get180Rotation() {
    return ROTATES[0];
  }

  @Override
  public int[][] get270Rotation() {
    return ROTATES[1];
  }
}
