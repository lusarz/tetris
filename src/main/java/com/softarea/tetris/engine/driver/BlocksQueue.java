package com.softarea.tetris.engine.driver;

import com.softarea.tetris.engine.blocks.Block;
import com.softarea.tetris.engine.blocks.factory.BlocksFactory;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlocksQueue {
    private static final int DEFAULT_QUEUE_SIZE = 3;


    private Queue<Block> blockQueue = new ArrayBlockingQueue<Block>(DEFAULT_QUEUE_SIZE);
    private BlocksFactory factory = new BlocksFactory();

    public Block getNextElement() {

        Block nextElement = blockQueue.poll();
        fill();
        return nextElement;
    }

    public BlocksQueue() {
    }

    private void fill() {
        for (int i = blockQueue.size(); i < DEFAULT_QUEUE_SIZE; i++) {
            blockQueue.add(factory.next());
        }
    }
}
