package com.softarea.tetris.drawing;

import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;

public interface DrawingApi {

    void drawGame(Block block, Board board);

    void startDrawing();
}
