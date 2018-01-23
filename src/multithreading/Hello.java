package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Hello {
	
	static void test(int i) {
		
		System.out.println(i);
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				test(1);
				return null;
			}
			
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
				executor.submit(callable);
		
	}

}
