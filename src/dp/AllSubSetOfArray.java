package dp;

import java.util.ArrayList;
import java.util.List;

public class AllSubSetOfArray {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] intput = { 1, 2, 3 };

        findAllSubSet(intput, 0, new ArrayList<Integer>());
        result.forEach(System.out::println);
    }

    private static void findAllSubSet(int[] intput, int idx,
            ArrayList<Integer> temp) {

        if (idx >= intput.length) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(intput[idx]);
        findAllSubSet(intput, idx + 1, temp);
        temp.remove(temp.size() - 1);
        findAllSubSet(intput, idx + 1, temp);

    }
}
