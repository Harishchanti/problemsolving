package multithreading;

class Counter implements Runnable {
	private int c = 0;

	public void increment() {
		/*
		 * try { Thread.sleep(10); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		c++;
	}

	public void decrement() {
		c--;
	}

	public int getValue() {
		// System.out.println("in getValue method ");

		return c;
	}

	@Override
	public void run() {
		// incrementing
		/*
		 * synchronized (this) { this.increment(); System.out.println(
		 * "Value for Thread After increment " +
		 * Thread.currentThread().getName() + " " + this.getValue()); //
		 * decrementing this.decrement();
		 * System.out.println("Value for Thread at last " +
		 * Thread.currentThread().getName() + " " + this.getValue()); }
		 */
		int i = 1;
		while (i < 10) {
			System.out.println(i + " name :" + Thread.currentThread().getName());
			i++;
		}

	}
}

public class TestRunnable {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter, "Thread-1");
		Thread t2 = new Thread(counter, "Thread-2");
		Thread t3 = new Thread(counter, "Thread-3");
		t1.start();
		t2.start();
		t3.start();
	}
}

/*
 * public class TestRunnable {
 * 
 * public static void main(String[] args) { int i = 10; TestThread t = new
 * TestThread(); Thread d = new Thread(t); Thread d2 = new Thread(t);
 * d.start();d2.start(); while (i < 500) { System.out.println(i); i++; } }
 * 
 * }
 * 
 * class TestThread implements Runnable {
 * 
 * @Override public void run() { int i = 0; while (i < 10) {
 * System.out.println(i); i++; }
 * 
 * }
 * 
 * }
 */
