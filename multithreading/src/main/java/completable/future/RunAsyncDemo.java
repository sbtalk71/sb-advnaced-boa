package completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncDemo {

	public static void main(String[] args) throws Exception{
		
		ExecutorService es= Executors.newVirtualThreadPerTaskExecutor();
		
		CompletableFuture<Void> cf=CompletableFuture.runAsync(()->System.out.println(Thread.currentThread()),es);
		
		cf.get();

	}

}
