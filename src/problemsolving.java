import java.util.*;

public class problemsolving {

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // Given Appointments.
        List<List<Integer>> v = new ArrayList<>();
        v.add(Arrays.asList(1, 5));
        v.add(Arrays.asList(3, 7));
        v.add(Arrays.asList(2, 6));
        v.add(Arrays.asList(10, 15));
        v.add(Arrays.asList(5, 6));
        v.add(Arrays.asList(4, 100));

        // sort according to start time of meet/appointment.
        // sort(v.begin(), v.end());
        // number of pair or appointments.
        int n = v.size();

        // for stoping the overlapping
        // vector<bool>vis(n,0);
        // traverse over and check for it.
        List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // to reduce extra/unwanted comparisons.
                 if(v.get(j).get(0) > v.get(i).get(1)) break;
                 else {
                     if (v.get(j).get(0) < v.get(i).get(1)) {
                         result.add(new Pair<>(
                                 new Pair<>(v.get(i).get(0), v.get(i).get(1)),
                                 new Pair<>(v.get(j).get(1), v.get(j).get(0))
                         ));
                     }
                 }
            }
        }

        // final output.
        for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> it : result) {
            System.out.printf("[%d,%d] having Conflict with [%d,%d]\n",
                    it.getKey().getKey(), it.getKey().getValue(),
                    it.getValue().getKey(), it.getValue().getValue());
        }
    }
}
