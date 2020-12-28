package company_interview;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface S {
    void m();
}
interface D {
    void ma();
}
public class Walmart implements S,D{

    static volatile int currentThread = 1;
    static Object ob = new Object();
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Map<String,String> map = new HashMap<>(1);
        map.put("dd","s");map.put("ddf","s");
        System.out.println(map);
        Map<String,String> t = new TreeMap<>();
        ExecutorService e = Executors.newFixedThreadPool(10);

        //t.put(null,"");

        /*String[] a = {"a", "b", "c"};
        List<String> aList = Arrays.asList("a", "b", "c");

        Optional opSt = aList.stream().filter(e -> {
            return e.equalsIgnoreCase("b");
        }).findFirst();

        if (opSt.isPresent()) System.out.print(opSt.get());

        *//*company_interview.A ob = new B();
        ob.m();*//*

        String s = "a";
        String s1 = "b";

        System.out.print(s.concat(s1));
        company_interview.Immutable i = new company_interview.Immutable(2, 3);
        company_interview.Immutable i1 = new company_interview.Immutable(3, 4);

        Map<String, Integer> map = new HashMap<>();
        *//*
        England - 1
USA -3
China -2
         *//*
        TreeMap<String, Integer> tMap = new TreeMap<>((o1, o2) -> {
            return o1.compareTo(o2);
        });
        tMap.put("England", 1);
        tMap.put("USA", 1);
        tMap.put("Chaina", 3);

        System.out.print(tMap);*/
        Thread t1 = new Thread(new PrintNumber(1));
        Thread t2 = new Thread(new PrintNumber(2));
        Thread.sleep(2);
        t1.start();
        t2.start();

    }

    @Override
    public void m() {

    }

    @Override
    public void ma() {

    }

    static class PrintNumber implements Runnable {
        int theadId;

        PrintNumber(int threadId) {
            this.theadId = threadId;
        }

        @Override
        public void run() {

            while (i < 10) {

                synchronized (ob) {
                    if (currentThread != theadId) {
                        try {
                            ob.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (currentThread == 1) {
                        System.out.println(" Thread number " + Thread.currentThread().getName() + "  " + i++);
                        currentThread = 2;
                    } else if (currentThread == 2) {

                        System.out.println(" Thread number " + Thread.currentThread().getName() + " " + i++);
                        currentThread = 1;
                    }
                    ob.notify();
                }

            }

        }
    }

}


final class Immutable {
    private final int x, y;
    private final List<String> list = null;

    public int getX() {
        return x;
    }

    public List<String> getList() {
        List<String> list1 = new ArrayList<>(list);
        return list1;
    }

    public int getY() {
        return y;
    }


    Immutable(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

interface A {
    default void m() {

    }

    ;
}

class HodlingDetails {

    Long totalRecords;
    Long recordsPerPage;
    Integer page;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Long getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(Long recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getNextPageURL() {
        return nextPageURL;
    }

    public void setNextPageURL(String nextPageURL) {
        this.nextPageURL = nextPageURL;
    }

    public List<ProtFolioDetails> getData() {
        return data;
    }

    public void setData(List<ProtFolioDetails> data) {
        this.data = data;
    }

    String nextPageURL;
    List<ProtFolioDetails> data;
}
class ProtFolioDetails {

    String date;
    String security;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    Integer quantity;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    String portfolio;
    Double price;
}



/*
class B implements company_interview.A {

    void m() {

    }

}
*/

