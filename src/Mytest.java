import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Mytest {

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


       /* Map ss =new LinkedHashMap<String,String>(33, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;

            }
        }*/
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
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