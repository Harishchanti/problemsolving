package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheImplementation {
    public static void main(String[] args) {

        Cache cache = new Cache(10);
        try {
            cache.put("k", "v", 2 * 10);
            Thread.sleep(10);
            //System.out.println(cache.get("k"));


            cache.put("k1", "v1", 9);
            Thread.sleep(10);
            //System.out.println(cache.get("k1"));

            Map<String,String> lMap = new LinkedHashMap<>();

            lMap.put("1","sd");

            lMap.put("2","sd");

            lMap.put("3","sd");

            System.out.println(lMap);

            lMap.remove("2");
            lMap.put("2","sdf");

            System.out.println(lMap);
            //String s = lMap.get(lMap.size()-1);
            //lMap.entrySet().toArray() [lMap.size()-1];
            String s = lMap.entrySet().iterator().next().getKey();
            System.out.println(s);
            lMap.remove(s);

            System.out.println(lMap);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
