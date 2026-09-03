package multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws Exception{
		ExecutorService es= Executors.newCachedThreadPool();
		
		Future<String> future= es.submit(new UppercaseTask("shantanu"));
		
		while(!future.isDone()) {
			System.out.println("Processing");
			Thread.sleep(100);
		}
		
		System.out.println(future.get());

	}

}
