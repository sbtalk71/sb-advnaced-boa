package threads.semaphores;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    static Semaphore semaphore = new Semaphore(2);

    static void accessDatabase() {

        try {
            semaphore.acquire();

            System.out.println(
                Thread.currentThread().getName()
                + " acquired connection");

            Thread.sleep(2000);

            System.out.println(
                Thread.currentThread().getName()
                + " releasing connection");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            Thread thread =
                new Thread(
                    SemaphoreExample::accessDatabase,
                    "Thread-" + i);

            thread.start();
        }
    }
}