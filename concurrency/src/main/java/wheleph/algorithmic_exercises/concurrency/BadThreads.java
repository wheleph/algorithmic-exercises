package wheleph.algorithmic_exercises.concurrency;

/**
 * Problem: The application should print out "Mares do eat oats." Is it guaranteed to always do this?
 * If not, why not? Would it help to change the parameters of the two invocations of Sleep?
 * How would you guarantee that all changes to message will be visible in the main thread?
 */
public class BadThreads {

    static String message;

    private static class CorrectorThread extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }

            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[]) throws InterruptedException {
        CorrectorThread correctorThread = new CorrectorThread();
        correctorThread.start();

        message = "Mares do not eat oats.";
        Thread.sleep(2000);

        correctorThread.join();

        // Key statement 2:
        System.out.println(message);
    }
}
