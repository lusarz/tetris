package com.softarea.tetris.drawing;

import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel implements DrawingApi {

    private static final int OFFSET = 10;
    private static final int SINGLE_BLOCK_SIZE = 20;

    Block block;
    Board board;

    public void drawGame(Block block, Board board) {
        this.block = block;
        this.board = board;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2d = (Graphics2D) g;

        if (board != null) {
            paintBoard(graphics2d);
        }
    }

    private void paintBoard(Graphics2D g2d) {
        g2d.drawRect(OFFSET, OFFSET, OFFSET + SINGLE_BLOCK_SIZE * board.getWidth(), OFFSET + SINGLE_BLOCK_SIZE * board.getHeight());


        g2d.setColor(Color.blue);
        paintBoardFilledPoints(g2d);
        paintBlock(g2d);
    }

    private void paintBlock(Graphics2D g2d) {
        for (int i = 0; i < block.getWidth(); i++) {
            for (int j = 0; j < block.getHeight(); j++) {
                if (block.getField(i, j) != 0) {
                    g2d.fillRect(OFFSET + (block.getX() + i) * SINGLE_BLOCK_SIZE, OFFSET + (block.getY() + j) * SINGLE_BLOCK_SIZE,
                            SINGLE_BLOCK_SIZE, SINGLE_BLOCK_SIZE);
                }
            }
        }
    }

    private void paintBoardFilledPoints(Graphics2D g2d) {
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (board.getField(i, j) != 0) {
                    g2d.fillRect(OFFSET + i * SINGLE_BLOCK_SIZE, OFFSET + j * SINGLE_BLOCK_SIZE,
                            SINGLE_BLOCK_SIZE, SINGLE_BLOCK_SIZE);
                }
            }
        }
    }

}
