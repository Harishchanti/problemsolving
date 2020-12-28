package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Integer>> l = new ArrayList<>();
        l.add(executorService.submit(new Task(1, 100)));
        l.add(executorService.submit(new Task(11, 200)));
        l.add(executorService.submit(new Task(21, 300)));

        for (Future<Integer> f : l) {

            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        executorService.shutdown();
    }
}


class Task implements Callable<Integer> {
    int i, j;

    Task(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int x = i; x <= j; x++) count++;
        return count;
    }
}