package wheleph.algorithmic_exercises.concurrency.producer_consumer;

public class IntBuffer {
    private int index;
    private int[] buffer = new int[8];

    public synchronized void add(int num) {
        while (index == buffer.length - 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        buffer[index++] = num;
        notifyAll();
    }

    public synchronized int remove() {
        while (index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        int elem = buffer[--index];
        notifyAll();
        return elem;
    }
}

