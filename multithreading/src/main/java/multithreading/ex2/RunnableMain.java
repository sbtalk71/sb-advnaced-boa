package multithreading.ex2;

import multithreading.TablePrinter;

public class RunnableMain {

	public static void main(String[] args) throws Exception{
		TablePrinter tablePrinter=new TablePrinter();
		
		Thread t1=new Thread(new Worker(tablePrinter, 7));
		Thread t2=new Thread(new Worker(tablePrinter, 8));
		Thread t3=new Thread(new Worker(tablePrinter,9));
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();

	}

}
