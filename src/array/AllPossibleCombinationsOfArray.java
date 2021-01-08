package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPossibleCombinationsOfArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Set<List<Integer>> outPut = new HashSet<>();
        for (int i = 0; i < Math.pow(2, a.length); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if ((i & (int) Math.pow(2, j)) >= 1) {
                    temp.add(a[j]);
                }
            }
            outPut.add(temp);

        }
        outPut.forEach(o -> {
            System.out.println(o);
        });

    }

}