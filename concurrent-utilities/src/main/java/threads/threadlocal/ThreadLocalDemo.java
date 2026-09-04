package threads.threadlocal;
public class ThreadLocalDemo {

    private static ThreadLocal<String> userName =
            new ThreadLocal<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            userName.set("John");

            System.out.println(
                Thread.currentThread().getName()
                + " : " + userName.get()
            );

        });

        Thread t2 = new Thread(() -> {

            userName.set("Alice");

            System.out.println(
                Thread.currentThread().getName()
                + " : " + userName.get()
            );

        });

        t1.start();
        t2.start();
    }
}