package threads;

public class TestThread implements Runnable {
    String name;

    public static void main(String[] args) {
        //new Thread(new TestThread("abc")).start();
        //new Thread(new TestThread("xyz")).start();
        Thread s = new Thread(new TestThread("sdf"));
        s.run();
        s.run();
        s.start();


    }

    TestThread(String s) {
        name = s;
    }


    @Override
    public void run() {
       /* m(1);
        m(2);*/
       System.out.println("runnnig");
    }

    public synchronized void m(int g) {
        System.out.println(name + " - " + g + " ");
    }
}
