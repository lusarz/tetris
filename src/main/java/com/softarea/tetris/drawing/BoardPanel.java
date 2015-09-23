package com.softarea.tetris.drawing;

import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.board.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel implements DrawingApi, Runnable {

    private static final int OFFSET = 10;
    private static final int SINGLE_BLOCK_SIZE = 20;

    private Block block;
    private Board board;

    private Graphics2D graphics2d;

    private boolean animateEnabled;

    public BoardPanel() {
        super();
        animateEnabled = true;
    }

    public void drawGame(Block block, Board board) {
        this.block = block;
        this.board = board;
    }

    public void paint(Graphics g) {
        super.paint(g);

        graphics2d = (Graphics2D) g;

        paintBoardBorder(board.getWidth(), board.getHeight());
        paintBoardFilledPoints();
        changeColor(Color.RED);
        paintBlock();
        Toolkit.getDefaultToolkit().sync();
    }

    public void changeColor(Color color) {
        graphics2d.setColor(color);
    }


    private void paintBoardBorder(int width, int height) {
        graphics2d.drawRect(OFFSET, OFFSET, SINGLE_BLOCK_SIZE * width, SINGLE_BLOCK_SIZE * height);
    }

    private void paintBlock() {
        for (int i = 0; i < block.getWidth(); i++) {
            for (int j = 0; j < block.getHeight(); j++) {
                paintBlockPoint(i, j);
            }
        }
    }

    protected void paintBlockPoint(int i, int j) {
        if (block.getField(i, j) != 0 && block.getY() + j >= 0) {
            graphics2d.fillRect(OFFSET + (block.getX() + i) * SINGLE_BLOCK_SIZE, OFFSET + (block.getY() + j) * SINGLE_BLOCK_SIZE,
                    SINGLE_BLOCK_SIZE, SINGLE_BLOCK_SIZE);
        }
    }

    private void paintBoardFilledPoints() {
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                paintBoardFilledPoint(i, j);
            }
        }
    }

    private void paintBoardFilledPoint(int i, int j) {
        if (board.getField(i, j) != 0) {
            graphics2d.fillRect(OFFSET + i * SINGLE_BLOCK_SIZE, OFFSET + j * SINGLE_BLOCK_SIZE,
                    SINGLE_BLOCK_SIZE, SINGLE_BLOCK_SIZE);
        }
    }

    public void run() {
        while (true) {
            //ApplicationContext.getInstance().getMainWindow().repaint();
            if (animateEnabled) {
                repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
