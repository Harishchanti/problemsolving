package array;

import java.util.TreeSet;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "bb4b";//"3Ba";
        TreeSet<String> res = new TreeSet<>();
        //permute(input, 0, input.length() - 1, res);
        permuteV2(input.toCharArray(), 0, res);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }

    private static void permuteV2(char[] input, int idx, TreeSet<String> res) {
        if (idx >= input.length) {
            res.add(String.valueOf(input));
            return;
        }

        for (int i = idx; i < input.length; i++) {
            swapV2(input, idx, i);
            permuteV2(input, idx + 1, res);
            swapV2(input, idx, i);
        }
    }

    private static void swapV2(char[] input, int idx, int i) {
        char t = input[idx];
        input[idx] = input[i];
        input[i] = t;
    }

    private static void permute(String str, int left, int right,
            TreeSet<String> res) {
        if (left == right) {
            //System.out.println(str);
            res.add(str);
            return;
        }

        for (int i = left; i <= right; i++) {
            str = swap(str, left, i);       // choose
            permute(str, left + 1, right, res);  // explore
            str = swap(str, left, i);       // backtrack
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
