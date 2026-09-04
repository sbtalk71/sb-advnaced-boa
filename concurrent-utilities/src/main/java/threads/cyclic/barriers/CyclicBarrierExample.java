package threads.cyclic.barriers;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier barrier =
            new CyclicBarrier(
                3,
                () -> System.out.println(
                    "=== All workers completed Phase 1 ===")
            );

        Runnable worker = () -> {

            try {

                String name =
                    Thread.currentThread().getName();

                System.out.println(
                    name + " doing Phase 1");

                Thread.sleep(
                    (long) (Math.random() * 3000));

                System.out.println(
                    name + " waiting at barrier");

                barrier.await();

                System.out.println(
                    name + " doing Phase 2");

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(worker, "Worker-1").start();
        new Thread(worker, "Worker-2").start();
        new Thread(worker, "Worker-3").start();
        
        
    }
}