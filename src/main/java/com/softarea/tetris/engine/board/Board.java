package com.softarea.tetris.engine.board;

public class Board {
    static int DEFAULT_WIDTH = 10;
    static int DEFAULT_HEIGHT = 20;

    int width;
    int height;


    boolean[][] gameCells;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        gameCells = new boolean[width][height];
    }

    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


    public void saveBlock(int x, int y, boolean[][] block) {
        //TODO: implement this
    }


    public boolean hasCollision(int x, int y, boolean[][] block) {
        System.out.println("HasCollision, x: " + x + ", y: " + y);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int boardX = x + i;
                int boardY = y + j;
                boolean boardBusy = isBoardBusy(boardX, boardY);
                boolean blockBusy = block[j][i];
                System.out.println("Block, i:" + i + ", j = " + j + ", busy: " + blockBusy);
                if (boardBusy && blockBusy) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardBusy(int boardX, int boardY) {
        System.out.print("BoardX: " + boardX + ", boardY: " + boardY);
        boolean boardBusy = false;
        if (boardX < 0) {
            boardBusy = true;
        } else if (boardX > this.width - 1) {
            boardBusy = true;
        } else if (boardY < 0) {
            boardBusy = false;
        } else if (boardY > this.height - 1) {
            boardBusy = true;
        } else {
            boardBusy = gameCells[boardX][boardY];
        }
        System.out.println(", isBusy: " + boardBusy);
        return boardBusy;
    }

    public boolean checkGameOver() {
        for (int i = 0; i < width; i++) {
            if (gameCells[i][0]) {
                return true;
            }
        }
        return false;
    }

    public int removeFullLines() {

        //TODO: implement this
        return 0;
    }
}
