package dp;

import java.util.ArrayList;
import java.util.List;

public class PrintAlltheSubsequence {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        List<List<Integer>> res = new ArrayList<>();

        //printSubSequence(a, 0, new StringBuilder());
        populateSubSequence(a, 0, new ArrayList<>(), res);
        for (List<Integer> outPut : res) {
            outPut.forEach(o -> System.out.print(o + " "));
            System.out.println("------------------");
        }

    }

    private static void populateSubSequence(int[] a, int i,
            ArrayList<Integer> outPut,
            List<List<Integer>> res) {
        if (i >= a.length) {
            res.add(new ArrayList<>(outPut));
            return;
        }

        outPut.add(a[i]);

        populateSubSequence(a, i + 1, outPut, res);

        outPut.remove(outPut.size() - 1);

        populateSubSequence(a, i + 1, outPut, res);

    }
}
