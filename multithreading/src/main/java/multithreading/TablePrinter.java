package multithreading;

public class TablePrinter {

	public void print(int num) {
		try {
			synchronized (this) {
				for (int i = 1; i < 11; i++) {
					System.out.println(num + " X " + i + " = " + (num * i));
					Thread.sleep(1000);
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
