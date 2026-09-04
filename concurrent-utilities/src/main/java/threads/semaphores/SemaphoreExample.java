package threads.semaphores;
import java.util.concurrent.Semaphore;

//A Semaphore controls how many threads can access a resource simultaneously
public class SemaphoreExample {

    static Semaphore semaphore = new Semaphore(2);

    static void accessDatabase() {

        try {
            semaphore.acquire();

            System.out.println(
                Thread.currentThread().getName()
                + " acquired connection");

            Thread.sleep(4000);

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