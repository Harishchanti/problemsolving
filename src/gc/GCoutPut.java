package gc;

import java.util.*;

public class GCoutPut extends Thread {

    static GCoutPut gCoutPut;
    static int count;

    public static void main(String[] args) throws InterruptedException {

        GCoutPut gCoutPut = new GCoutPut();
        gCoutPut = null;
        System.gc();
        Thread.sleep(1000);
        gCoutPut = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("finalizes " + count + " times ");

        /*List<Integer> list = new ArrayList<>();
        list.add(3,1);
        System.out.print(list);
*/
        Map<String, Integer> map = new HashMap<>();
        map.put("sd", 1);

        Collections.unmodifiableMap(map);
        map.put("ff", 3);
        System.out.print(map);

        String a = "abc";
        String b = new String(a);
        int value = 0;
        value = (a == b) ? 1 : 2;
        if (value == 1) {
            System.out.print("1");

        } else if (value == 2) {
            System.out.print("2");
        } else {
            System.out.print("0");

        }
    }

    @Override
    protected void finalize() {
        count++;
        gCoutPut = this;

    }
}
