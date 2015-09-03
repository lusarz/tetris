package com.softarea.tetris.drawing;

import com.softarea.tetris.engine.board.Board;

public interface DrawingApi {
    void drawBoard(BlockOnBoard actualBlock, Board board);
}
