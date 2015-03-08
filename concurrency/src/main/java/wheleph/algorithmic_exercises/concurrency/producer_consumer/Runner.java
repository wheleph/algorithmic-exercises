package wheleph.algorithmic_exercises.concurrency.producer_consumer;

public class Runner {

    /**
     * PROBLEM  Write a Producer thread and a Consumer thread that share a fixed-
     * size buffer and an index to access the buffer. The Producer should place numbers
     * into the buffer, and the Consumer should remove the numbers. The order in
     * which the numbers are added or removed is not important.
     */
    public static void main(String[] args) {
        IntBuffer buffer = new IntBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
