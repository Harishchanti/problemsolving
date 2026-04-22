package array;

import java.util.TreeSet;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "bb4b";//"3Ba";
        TreeSet<String> res = new TreeSet<>();
        permute(input, 0, input.length() - 1, res);
        for (String s : res) {
            System.out.print(s + " ");
        }
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
