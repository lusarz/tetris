package com.softarea.tetris.engine.blocks.factory;

import com.softarea.tetris.engine.blocks.AbstractBlock;
import com.softarea.tetris.engine.blocks.LBlock;

public class BlocksFactory {

    public BlocksFactory() {
    }

    public AbstractBlock next() {
        return new LBlock();
    }
}
