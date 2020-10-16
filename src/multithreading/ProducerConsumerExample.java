package multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread producere = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sharedData.producce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer");


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sharedData.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "consumer");

        producere.start();
        consumer.start();
    }

    static class SharedData {
        List<Integer> list = new ArrayList<>();

        int size = 3;

        public void producce() throws InterruptedException {
            int value = 0;
            while (true) {


                synchronized (this) {

                    while (list.size() == size)
                        wait();

                    System.out.println("Adding value " +Thread.currentThread().getName()+" : "+ value);
                    list.add(value++);

                    notifyAll();
                    Thread.sleep(5000);
                }
            }
        }


        public void consume() throws InterruptedException {

            while (true) {

                synchronized (this) {
                    //list.add(value++);

                    while (list.isEmpty()) {
                        wait();
                    }

                    if (!list.isEmpty()) {
                        System.out.println(" consuming by "+Thread.currentThread().getName() + list.remove(0));
                    }
                    notify();
                }
            }
        }
    }
}
