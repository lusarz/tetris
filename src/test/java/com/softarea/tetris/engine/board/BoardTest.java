package com.softarea.tetris.engine.board;

import com.softarea.tetris.engine.blocks.Block;
import junit.framework.TestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest extends TestCase {

  private int TEST_BLOCK_WIDTH = 3;
  private int TEST_BLOCK_HEIGHT = 2;


  Block blockMock;
  Board board;
  int boardWidth;
  int boardHeight;

  public void setUp() throws Exception {
    super.setUp();

    boardWidth = 10;
    boardHeight = 20;

    prepareBlockMock();

    board = new Board(boardWidth, boardHeight);
  }


  public void testCheckCollision() throws Exception {
    when(blockMock.getY()).thenReturn(10);

    when(blockMock.getX()).thenReturn(-1);
    assertTrue(board.checkCollision(blockMock));

    when(blockMock.getX()).thenReturn(0);
    assertFalse(board.checkCollision(blockMock));

    when(blockMock.getX()).thenReturn(board.getWidth() - TEST_BLOCK_WIDTH + 1);
    assertTrue(board.checkCollision(blockMock));

    when(blockMock.getX()).thenReturn(board.getWidth() - TEST_BLOCK_WIDTH);
    assertFalse(board.checkCollision(blockMock));

    when(blockMock.getY()).thenReturn(board.getHeight() - TEST_BLOCK_HEIGHT + 1);
    assertTrue(board.checkCollision(blockMock));

    when(blockMock.getY()).thenReturn(board.getHeight() - TEST_BLOCK_HEIGHT);
    assertFalse(board.checkCollision(blockMock));


    board.saveBlock(blockMock);
    assertTrue(board.checkCollision(blockMock));
  }


  private void prepareBlockMock() {
    blockMock = mock(Block.class);
    when(blockMock.getHeight()).thenReturn(TEST_BLOCK_HEIGHT);
    when(blockMock.getWidth()).thenReturn(TEST_BLOCK_WIDTH);

    when(blockMock.getField(0, 0)).thenReturn(1);
    when(blockMock.getField(1, 0)).thenReturn(1);
    when(blockMock.getField(2, 0)).thenReturn(1);
    when(blockMock.getField(0, 1)).thenReturn(1);
    when(blockMock.getField(1, 1)).thenReturn(0);
    when(blockMock.getField(2, 1)).thenReturn(0);
  }
}
