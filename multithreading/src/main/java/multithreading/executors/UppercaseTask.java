package multithreading.executors;

import java.util.concurrent.Callable;

public class UppercaseTask implements Callable<String> {

	private String input;

	public UppercaseTask(String input) {
		this.input = input;
	}

	@Override
	public String call() throws Exception {

		String result = "";
		try {
			result = input.toUpperCase();
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
