package wheleph.algorithmic_exercises.concurrency.producer_consumer;

import java.util.Random;

public class Producer extends Thread {
    private IntBuffer buffer;

    public Producer(IntBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            int num = r.nextInt(100);
            buffer.add(num);
            System.out.println("Produced " + num);
        }
    }
}