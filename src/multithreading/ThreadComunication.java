package multithreading;

import java.util.Arrays;
import java.util.List;

public class ThreadComunication {
    static List<Integer> list = Arrays.asList(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new ChildClass(list));
        t.start();

        while (list.get(0) < 100) {
            synchronized (list) {

                while(list.get(0)% 2 == 0) list.wait();


                System.out.println(" Thread name " + Thread.currentThread().getName() + " " + list.get(0));
                list.set(0, list.get(0) + 1);

                Thread.sleep(1000);
                list.notifyAll();

               /* if (list.get(0) % 2 == 0) {
                    System.out.println(" Thread name " + Thread.currentThread().getName() + " " + list.get(0));
                    list.set(0, list.get(0) + 1);
                    list.notifyAll();
                } else {
                    list.wait();
                }*/
            }
        }
    }
}

class ChildClass implements Runnable {

    List<Integer> list;

    ChildClass(List<Integer> l) {
        list = l;
    }

    @Override
    public void run() {

        while (list.get(0) < 100) {
            synchronized (list) {

                while(list.get(0)% 2 == 1) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                System.out.println(" Thread name " + Thread.currentThread().getName() + " " + list.get(0));
                list.set(0, list.get(0) + 1);

                list.notifyAll();

               /* if (list.get(0) % 2 == 1) {
                    System.out.println(" Thread name " + Thread.currentThread().getName() + " " + list.get(0));
                    list.set(0, list.get(0) + 1);
                    list.notifyAll();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/

            }
        }
    }
}