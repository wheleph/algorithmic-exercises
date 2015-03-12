package wheleph.algorithmic_exercises.concurrency.producer_consumer_queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> processingQueue;

    public Consumer(BlockingQueue<String> processingQueue) {
        this.processingQueue = processingQueue;
    }

    public void run() {
        Random random = new Random();
        try {
            for (String message = processingQueue.take(); !message.equals("DONE"); message = processingQueue.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                Thread.sleep(random.nextInt(5000));
            }
        } catch (InterruptedException e) {
        }
    }
}