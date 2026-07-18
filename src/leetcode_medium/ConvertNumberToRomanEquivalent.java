package leetcode_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertNumberToRomanEquivalent {
    public static void main(String[] args) {

        int[] input = {1, 49, 23};
        System.out.println(convert(input));

        System.out.println(convert("I"));      // 1
        System.out.println(convert("XLIX"));   // 49
        System.out.println(convert("XXIII"));  // 23
    }

    public static List<String> convert(int[] nums) {
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        List<String> result = new ArrayList<>();

        for (int num : nums) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    sb.append(symbols[i]);
                    num -= values[i];
                }
            }

            result.add(sb.toString());
        }

        return result;
    }

    public static int convert(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));

            if (i < s.length() - 1 && curr < map.get(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}
