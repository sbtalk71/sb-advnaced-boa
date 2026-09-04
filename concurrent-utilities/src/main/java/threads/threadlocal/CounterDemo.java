package threads.threadlocal;
public class CounterDemo {

    private static ThreadLocal<Integer> counter =
            ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        Runnable task = () -> {

            counter.set(counter.get() + 1);
            counter.set(counter.get() + 1);
            counter.set(counter.get() + 1);

            System.out.println(
                Thread.currentThread().getName()
                + " counter = " + counter.get()
            );
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}