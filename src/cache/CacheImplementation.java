package cache;

public class CacheImplementation {
    public static void main(String[] args) {

        Cache cache = new Cache(10);
        try {
            cache.put("k", "v", 2 * 10);
            Thread.sleep(10);
            System.out.println(cache.get("k"));


            cache.put("k1", "v1", 9);
            Thread.sleep(10);
            System.out.println(cache.get("k1"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
