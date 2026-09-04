package threads.reentrant.locks;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockProof {
    // 1. Create a ReentrantLock instance
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Run the demonstration
        firstMethod();
    }

    public static void firstMethod() {
        lock.lock(); // First lock acquisition
        try {
            System.out.println("--- Inside firstMethod ---");
            System.out.println("Current Hold Count: " + lock.getHoldCount());
            
            // 2. Call the second method while still holding the lock
            secondMethod(); 
            
            System.out.println("--- Back in firstMethod ---");
            System.out.println("Hold Count before exiting firstMethod: " + lock.getHoldCount());
        } finally {
            lock.unlock(); // First unlock
        }
    }

    public static void secondMethod() {
        lock.lock(); // 3. Re-entering the lock (Same thread)
        try {
            System.out.println("\n--- Inside secondMethod ---");
            // 4. This proves reentrancy. Hold count should be 2.
            System.out.println("Current Hold Count: " + lock.getHoldCount()); 
        } finally {
            lock.unlock(); // Second unlock
        }
    }
}
