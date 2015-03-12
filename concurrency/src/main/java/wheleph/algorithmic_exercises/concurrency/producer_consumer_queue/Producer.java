package wheleph.algorithmic_exercises.concurrency.producer_consumer_queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> processingQueue;

    public Producer(BlockingQueue<String> processingQueue) {
        this.processingQueue = processingQueue;
    }

    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            processingQueue.add(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }
        }
        processingQueue.add("DONE");
    }
}
