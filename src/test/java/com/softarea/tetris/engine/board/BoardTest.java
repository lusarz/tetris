package com.softarea.tetris.engine.board;

import com.softarea.tetris.engine.blocks.Block;
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

        //test left border
        assertTrue(board.hasCollision(-2, 2, TEST_BLOCK));

        //test before left border
        assertFalse(board.hasCollision(-1, 2, TEST_BLOCK));


        //test left where some board is busy
        for (int i = 0; i < board.height; i++) {
            board.gameCells[0][i] = true;
        }
        assertTrue(board.hasCollision(-1, 2, TEST_BLOCK));
    }

    public void testRightCollision() {
        Board board = new Board();
        //test right border
        assertTrue(board.hasCollision(board.width - Block.DEFAULT_SIZE + 2, 2, TEST_BLOCK));

        //test before right border
        assertFalse(board.hasCollision(board.width - Block.DEFAULT_SIZE + 1, 2, TEST_BLOCK));


        //test right where some board is busy
        for (int i = 0; i < board.height; i++) {
            board.gameCells[board.width - 1][i] = true;
        }
        assertTrue(board.hasCollision(board.width - Block.DEFAULT_SIZE + 1, 2, TEST_BLOCK));
    }

    public void testDownCollision() {
        Board board = new Board();

        //test bottom border
        assertTrue(board.hasCollision(2, board.height - Block.DEFAULT_SIZE + 2, TEST_BLOCK));

        //test before bottom border
        assertFalse(board.hasCollision(2, board.height - Block.DEFAULT_SIZE + 1, TEST_BLOCK));

        //test where last row is busy
        for (int i = 0; i < board.width; i++) {
            board.gameCells[i][board.height - 1] = true;
        }

        assertTrue(board.hasCollision(2, board.height - Block.DEFAULT_SIZE + 1, TEST_BLOCK));
    }

    public void testGameOver() {
        Board board = new Board();
        assertFalse(board.checkGameOver());
        board.gameCells[4][0] = true;
        assertTrue(board.checkGameOver());
    }

    public void testRemoveFullLines() {

    }

    /*public void testStartNewBlock() {

    }*/
}
