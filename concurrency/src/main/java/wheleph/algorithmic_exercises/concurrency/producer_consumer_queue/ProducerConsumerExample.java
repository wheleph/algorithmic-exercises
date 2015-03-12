package wheleph.algorithmic_exercises.concurrency.producer_consumer_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Modify the producer-consumer example in Guarded Blocks to use a standard library class instead of the Drop class.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> processingQueue = new ArrayBlockingQueue<String>(1);
        (new Thread(new Producer(processingQueue))).start();
        (new Thread(new Consumer(processingQueue))).start();
    }
}
