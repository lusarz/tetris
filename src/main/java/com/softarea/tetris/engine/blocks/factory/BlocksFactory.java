package com.softarea.tetris.engine.blocks.factory;

import com.softarea.tetris.engine.blocks.*;

import java.util.Random;

public class BlocksFactory {

    Random random;

    public BlocksFactory() {
        random = new Random();
    }

    public AbstractBlock next() {
        int kind = Math.abs(random.nextInt() % 7);
        System.out.println(kind);

        switch (kind) {
            case 0:
                return new LBlock();
            case 1:
                return new LMirroredBlock();
            case 2:
                return new SBlock();
            case 3:
                return new SquareBlock();
            case 4:
                return new StraightBlock();
            case 5:
                return new TBlock();
            case 6:
                return new ZBlock();
            default:
                return new TBlock();
        }
    }
}
