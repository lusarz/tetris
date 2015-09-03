package com.softarea.tetris.engine.board;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
    private static final boolean[][] TEST_BLOCK = {
            {false, false, true, false},
            {false, false, true, false},
            {false, true, true, false},
            {false, false, false, false}
    };

    public void testCellsEmptyAfterCreate() {
        Board board = new Board();
        boolean emptyCells = true;

        for (int i = 0; i < board.gameCells.length; i++) {
            boolean[] column = board.gameCells[i];
            for (int j = 0; j < column.length; j++) {
                if (board.gameCells[i][j]) {
                    emptyCells = false;
                    break;
                }
            }
        }
        assertTrue(emptyCells);
    }

    public void testLeftCollision() {
        Board board = new Board();
        assertTrue(board.hasCollision(-2, 2, TEST_BLOCK));
    }

    public void testRightCollision() {
        Board board = new Board();
        assertTrue(board.hasCollision(-2, 2, TEST_BLOCK));
    }

    public void testStartNewBlock() {

    }
}
