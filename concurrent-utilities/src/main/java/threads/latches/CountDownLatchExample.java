package threads.latches;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args)
            throws InterruptedException {

        CountDownLatch latch =
            new CountDownLatch(3);
System.out.println("Count ="+latch.getCount());
        Runnable service = () -> {

            try {

                System.out.println(
                    Thread.currentThread().getName()
                    + " starting...");

                Thread.sleep(
                    (long) (Math.random() * 3000));

                System.out.println(
                    Thread.currentThread().getName()
                    + " ready");

                latch.countDown();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(service, "Database").start();
        new Thread(service, "Redis").start();
        new Thread(service, "Kafka").start();

        System.out.println("Application waiting...");

        latch.await();

        System.out.println(
            "All services ready. Application started."+latch.getCount());
    }
}