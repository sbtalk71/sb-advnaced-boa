package threads.threadlocal;
public class ThreadLocalContext {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            UserContext.setUser("Alice");

            System.out.println(
                Thread.currentThread().getName()
                + " -> User = "
                + UserContext.getUser()
            );

            processOrder();

            UserContext.clear();
        }, "Thread-1");


        Thread t2 = new Thread(() -> {

            UserContext.setUser("Bob");

            System.out.println(
                Thread.currentThread().getName()
                + " -> User = "
                + UserContext.getUser()
            );

            processOrder();

            UserContext.clear();
        }, "Thread-2");


        t1.start();
        t2.start();
    }


    static void processOrder() {

        System.out.println(
            Thread.currentThread().getName()
            + " -> Processing order for "
            + UserContext.getUser()
        );

        saveOrder();
    }


    static void saveOrder() {

        System.out.println(
            Thread.currentThread().getName()
            + " -> Saving order for "
            + UserContext.getUser()
        );
    }
}