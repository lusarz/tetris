package com.softarea.tetris.engine.board;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

    public void testCellsEmptyAfterCreate() {
        Board board = new Board(null);
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

    public void testStartNewBlock() {
        
    }
}
