package multithreading;

public class PrintData {

    private static volatile int currentThread = 1;
    private static Object object = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Printer(1, "ping"));
        Thread t2 = new Thread(new Printer(2, "pong"));

        t1.start();
        t2.start();

    }

    static class Printer implements Runnable {
        int threadId;
        String data;

        public Printer(int threadId, String data) {
            this.threadId = threadId;
            this.data = data;
        }

        @Override
        public void run() {


            while (true) {

                synchronized (object) {
                    if (currentThread != threadId) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {

                        System.out.println(Thread.currentThread().getName() + " " + data);

                        if (currentThread == 1) {
                            currentThread = 2;
                        } else if (currentThread == 2) {
                            currentThread = 1;
                        }
                        object.notifyAll();
                    }
                }
            }
        }
    }

}
