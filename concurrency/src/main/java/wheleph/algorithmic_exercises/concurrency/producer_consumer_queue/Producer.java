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

        try {
            for (int i = 0; i < importantInfo.length; i++) {
                processingQueue.put(importantInfo[i]);
                Thread.sleep(random.nextInt(5000));
            }
            processingQueue.put("DONE");
        } catch (InterruptedException e) {
        }
    }
}
