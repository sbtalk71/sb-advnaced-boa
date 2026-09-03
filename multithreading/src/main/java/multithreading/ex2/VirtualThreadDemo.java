package multithreading.ex2;

import multithreading.TablePrinter;

public class VirtualThreadDemo {

	public static void main(String[] args) throws Exception {
		TablePrinter tablePrinter=new TablePrinter();
		
		Thread t1=Thread.ofVirtual().unstarted(new Worker(tablePrinter,7));
		Thread t2=Thread.ofVirtual().unstarted(new Worker(tablePrinter,7));
		Thread t3=Thread.ofVirtual().unstarted(new Worker(tablePrinter,7));
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();

	}

}
