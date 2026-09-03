package multithreading.ex1;

import multithreading.TablePrinter;

public class MyThreadMain {

	public static void main(String[] args) throws Exception{
		System.out.println(Thread.currentThread().getName()+" starts");
		TablePrinter tablePrinter=new TablePrinter();
		
		MyThread t1= new MyThread(tablePrinter, 7);
		
		t1.start();
		System.out.println(t1.getState()+" "+t1.getPriority());

		t1.join();
		System.out.println(Thread.currentThread().getName()+" exits");
	}

}
