package multithreading.ex2;

import multithreading.TablePrinter;

public class Worker implements Runnable {

	private TablePrinter tablePrinter;
	private int num;
	
	public Worker(TablePrinter tablePrinter, int num) {
		this.tablePrinter = tablePrinter;
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println(" started by "+Thread.currentThread());
		this.tablePrinter.print(num);
		System.out.println(" completed by "+Thread.currentThread());
	}

}
