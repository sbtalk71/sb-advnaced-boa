package threads.reentrant.locks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    static class BankAccount {

        private int balance = 1000;

        private final Lock lock = new ReentrantLock();

        public void withdraw(int amount) {

           lock.lock();

            try {
                if (balance >= amount) {
                    System.out.println(
                        Thread.currentThread().getName()
                        + " withdrawing " + amount);

                    balance -= amount;

                    System.out.println(
                        "Balance = " + balance);
                } else {
                    System.out.println("Insufficient balance");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(
            () -> account.withdraw(700), "Thread-1");

        Thread t2 = new Thread(
            () -> account.withdraw(700), "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}