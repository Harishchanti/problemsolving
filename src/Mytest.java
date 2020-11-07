import javax.print.attribute.standard.NumberUp;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Mytest {
    String s;

    public Mytest(String ddf) {
        s = ddf;
    }

    public static void main(String[] args) {

        S d = new S(6);
        d.g = 9;
        S f = new S(20);
        d = f;

        System.out.println(d.g);

        Map<String, Temp> map = new HashMap<>(2);

        map.put("abc", new Temp("mn", "dfd"));

        map.put("dfdf", new Temp(4, "fgvdf"));

        map.put("abcg", new Temp(new Boolean(true), "dfgdfgf"));
        map.put("fgdfgdfg", new Temp(new Boolean(true), "dfgdfgf"));

        Map<String, Object> a = new HashMap<>();

        Set sss = map.keySet();

        //Collections.sort(sss);
        sss = new TreeSet(sss);

        a.put("a", 22);
        a.put("sdfsd", "sdf");


        System.out.println(testmeth());


        System.out.print(a);

       /* Map ss =new LinkedHashMap<String,String>(33, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;

            }
        }*/
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        Map<String, String> gg = new LinkedHashMap<>();

        ttt g = new ttt();
        g.m();


        System.out.println();
        String s1 = "slip";
        Integer hhh = new Integer(5);
        String s2 = fli(s1, hhh);
        System.out.println(hhh);

        System.out.println(s1 + " " + s2);

        rrr r = new rrr();
        rrr f1 = new ttt();
        ttt f3 = new ttt();

        prd(r);
        prd(f1);
        prd(f3);

        HashSet<Object> set = new HashSet<>();
        Mytest fff = new Mytest("ddf");
        Mytest fff1 = new Mytest("ddf");

        String df = new String("ddf");
        String ddf = new String("ddf");

        set.add(fff);
        set.add(fff1);
        set.add(df);
        set.add(ddf);

        System.out.println(set.size());


        fof(2);


    }

    interface  Ia {
        int i = 4;
    }
    class  A {
        int i =1;
        int j = 2;
    }

    class B extends A implements Ia {
        void m() {
            //System.out.print(i);
        }
    }


    private static void fof(int i) {
        if (i >= 0) {
            fof(i - 1);
        }
        System.out.print("Nu : "+ i);
    }


    private static void prd(rrr r) {
        r.m();
    }

    private static String fli(String s1, Integer s) {
        s += 33;
        s1 = s1 + "stream";
        System.out.print(s1 + " ");
        return "stream";
    }


    static class rrr {
        rrr() {
            //System.out.println("rrr");
        }

        void m() {
            System.out.println("base");
        }
    }

    static class ttt extends rrr {

        ttt() {
            System.out.print("ttt");
        }

        void m() {
            System.out.println("derived");
        }
    }

    private static int testmeth() {

        try {
            int d = 7 / 0;
        } catch (Exception e) {
            return 3;
        } finally {
            return 9;
        }
    }
}

class Teee<N extends Number> {

    N min, max;

    public N getMax() {
        return max;
    }

    public void add(N aa) {
        if (min == null || aa.doubleValue() < min.doubleValue()) {

        }
    }
}

class Temp<T> {
    T data;
    String st;

    @Override
    public String toString() {
        return "Temp{" +
                "data=" + data +
                ", st='" + st + '\'' +
                '}';
    }

    Temp(T t, String s) {
        data = (T) t;
        st = s;
    }

}

final class S {
    int g;

    S(int d) {
        g = d;
    }
}