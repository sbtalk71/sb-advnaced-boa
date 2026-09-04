package threads.atomin.safe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Counter {

    private final AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
    
    public static void main(String[] args) {
    	Counter counter = new Counter();
    	  List<Thread> threads = new ArrayList<>();
    	  
    	IntStream.range(0, 10)
    	         .forEach(i ->{
    	           Thread thread=  new Thread(() -> {
    	                 for (int j = 0; j < 1000; j++) {
    	                     counter.increment();
    	                 }
    	             });
    	             threads.add(thread);
    	             thread.start();
    	         });
    	
    	 // Wait for all threads to finish
    	System.out.println(threads.size());
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    	System.out.println("Counter Value : "+counter.getCount());
	}
}