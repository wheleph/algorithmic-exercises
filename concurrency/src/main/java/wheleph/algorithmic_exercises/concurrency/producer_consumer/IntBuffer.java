package wheleph.algorithmic_exercises.concurrency.producer_consumer;

public class IntBuffer {
    private int index;
    private int[] buffer = new int[8];

    public void add(int num) {
        while (true) {
            if (index < buffer.length) {
                buffer[index++] = num;
                return;
            }
        }
    }

    public int remove() {
        while (true) {
            if (index > 0) {
                return buffer[--index];
            }
        }
    }
}

