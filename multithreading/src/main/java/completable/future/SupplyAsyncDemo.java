package completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class SupplyAsyncDemo {

	public static void main(String[] args) throws Exception {

		ExecutorService es = Executors.newVirtualThreadPerTaskExecutor();
		CompletableFuture<String> asyncMessage = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread());
			return "hello";
		}).thenApplyAsync(message -> {
			System.out.println(Thread.currentThread());
			return message.concat(" World ");
		}, es).thenApplyAsync(message -> {
			System.out.println(Thread.currentThread());
			return message.toUpperCase();
		});

		System.out.println(asyncMessage.get());

	}

}
