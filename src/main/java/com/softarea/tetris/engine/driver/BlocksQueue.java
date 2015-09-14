package com.softarea.tetris.engine.driver;

import com.softarea.tetris.engine.blocks.AbstractBlock;
import com.softarea.tetris.engine.blocks.factory.BlocksFactory;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlocksQueue {
    private static final int DEFAULT_QUEUE_SIZE = 3;


    private Queue<AbstractBlock> blockQueue = new ArrayBlockingQueue<AbstractBlock>(DEFAULT_QUEUE_SIZE);
    private BlocksFactory factory = new BlocksFactory();

    public AbstractBlock getNextElement() {

        AbstractBlock nextElement = blockQueue.poll();
        fill();
        return nextElement;
    }

    public BlocksQueue() {
        fill();
    }

    private void fill() {
        for (int i = blockQueue.size(); i < DEFAULT_QUEUE_SIZE; i++) {
            blockQueue.add(factory.next());
        }
    }
}
