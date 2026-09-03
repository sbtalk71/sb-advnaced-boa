package multithreading.ex1;

import multithreading.TablePrinter;

public class MyThread extends Thread {

	private TablePrinter tablePrinter;
	private int num;
	
	public MyThread(TablePrinter tablePrinter, int num) {
		this.tablePrinter = tablePrinter;
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread()+" starts");
		this.tablePrinter.print(num);
		System.out.println(Thread.currentThread()+" exits");
	}
}
