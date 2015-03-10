package wheleph.algorithmic_exercises.concurrency;

/**
 * PROBLEM Five introspective and introverted philosophers are sitting at a circular
 * table. In front of each philosopher is a plate of food. A fork (or a chopstick) lies
 * between each philosopher, one by the philosopher’s left hand and one by the right
 * hand. A philosopher cannot eat until he or she has forks in both hands. Forks
 * are picked up one at a time. If a fork is unavailable, the philosopher simply waits
 * for the fork to be freed. When a philosopher has two forks, he or she eats a few
 * bites and then returns both forks to the table. If a philosopher cannot obtain both
 * forks for a long time, he or she will starve. Is there an algorithm that will ensure
 * that no ­ philosophers starve?
 */
public class DiningPhilosophers {

    private class Philosopher implements Runnable {

        private int index;
        private int firstForkIndex;
        private int secondForkIndex;

        public Philosopher(int index, int firstForkIndex, int secondForkIndex) {
            this.index = index;
            this.firstForkIndex = firstForkIndex;
            this.secondForkIndex = secondForkIndex;
        }

        @Override
        public void run() {
            System.out.printf("Starting philosopher #%d%n", index);

            while (true) {
                synchronized (forks[firstForkIndex]) {
                    System.out.printf("Philosopher #%d picked fork #%d%n", index, firstForkIndex);
                    synchronized (forks[secondForkIndex]) {
                        System.out.printf("Philosopher #%d picked fork #%d%n", index, secondForkIndex);
                        System.out.printf("Philosopher #%d is eating...%n", index);
                        System.out.printf("Philosopher #%d dropped fork #%d%n", index, secondForkIndex);
                    }
                    System.out.printf("Philosopher #%d dropped fork #%d%n", index, firstForkIndex);
                }

                System.out.printf("Philosopher #%d staring thinking...%n", index);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.printf("Philosopher #%d got interrupted. Exiting.%n", index);
                    return;
                }
                System.out.printf("Philosopher #%d finished thinking%n", index);
            }

        }
    }

    private static final int NUMBER_OF_PHILOSOPHERS = 5;
    private Philosopher[] philosophers;
    private Object[] forks;

    public DiningPhilosophers() {
        forks = new Object[NUMBER_OF_PHILOSOPHERS];
        philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            int firstFork = Math.min(i, (i + 1) % NUMBER_OF_PHILOSOPHERS);
            int secondFork = Math.max(i, (i + 1) % NUMBER_OF_PHILOSOPHERS);
            philosophers[i] = new Philosopher(i, firstFork, secondFork);
        }
    }

    private void start() {
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            new Thread(philosophers[i]).start();
        }
    }

    public static void main(String[] args) {
        new DiningPhilosophers().start();
    }
}
