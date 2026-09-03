package multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import multithreading.TablePrinter;
import multithreading.ex2.Worker;

public class ExecutorDemo01 {

	public static void main(String[] args) throws Exception{
		TablePrinter tp = new TablePrinter();
		
		//ExecutorService es= Executors.newFixedThreadPool(2);
		//ExecutorService es= Executors.newCachedThreadPool();
		ExecutorService es= Executors.newVirtualThreadPerTaskExecutor();
	Future<?> f1=es.submit(new Worker(tp, 5));
	Future<?> f2=es.submit(new Worker(tp, 6));
	Future<?> f3=es.submit(new Worker(tp, 8));
		
		es.shutdown();
		//es.awaitTermination(10, TimeUnit.SECONDS);
		f1.get();
		f2.get();
		f3.get();
		System.out.println("completed");
		
	}

}
