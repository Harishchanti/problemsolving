package multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SimpleThreadExample {

	public static void main(String[] args) {
		Semaphore oddPermit = new Semaphore(0);
		Semaphore evenPermit = new Semaphore(1);

		Thread t1 = new Thread(new Even(0, "t1", oddPermit, evenPermit));
		Thread t2 = new Thread(new Odd(1, "t2", oddPermit, evenPermit));
		t1.start();
		t2.start();
		
	}

}

class Even implements Runnable {
	int i;
	String name;
	Semaphore oddPermit;
	Semaphore evenPermit;

	public Even(int i, String name, Semaphore oddPermit, Semaphore evenPermit) {
		super();
		this.i = i;
		this.name = name;
		this.oddPermit = oddPermit;
		this.evenPermit = evenPermit;
	}

	@Override
	public void run() {
		for (int j = i; j <= 5; j++) {
			try {
				evenPermit.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + " " + name);
			i = i + 2;
			oddPermit.release();
		}
	}

}

class Odd implements Runnable {
	int i;
	String name;
	Semaphore oddPermit;
	Semaphore evenPermit;

	public Odd(int i, String name, Semaphore oddPermit, Semaphore evenPermit) {
		super();
		this.i = i;
		this.name = name;
		this.oddPermit = oddPermit;
		this.evenPermit = evenPermit;
	}

	@Override
	public void run() {
		for (int j = i; j <= 5; j++) {
			try {
				oddPermit.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + " " + name);
			i = i + 2;
			evenPermit.release();
		}
	}

}
