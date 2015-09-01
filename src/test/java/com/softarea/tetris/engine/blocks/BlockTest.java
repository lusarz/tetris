package com.softarea.tetris.engine.blocks;

import junit.framework.TestCase;

public class BlockTest extends TestCase {
    public void testGetNext() throws Exception {
        LBlock lBlock = new LBlock();
        assertEquals(lBlock.getNextRotation(2, 3), 0);
        assertEquals(lBlock.getPreviousRotation(0, 4), 3);

    }
}
