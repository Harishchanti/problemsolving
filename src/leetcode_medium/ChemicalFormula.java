package leetcode_medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given a chemcal formula CH2 find the weight,
CH2 => 10 + 15 * 2 = 40
(CH2)2O2 => (10 + 15 * 2) * 2 + 5 *2 = 90
C-10
H-15
O-5
 */
public class ChemicalFormula {
    private static final Map<Character, Integer> weights = new HashMap<>();

    static {
        weights.put('C', 10);
        weights.put('H', 15);
        weights.put('O', 5);
    }

    public static int calculate(String formula) {
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        int i = 0;

        while (i < formula.length()) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                // Push current sum and reset
                stack.push(currentSum);
                currentSum = 0;
                i++;
            } else if (ch == ')') {
                i++;
                int multiplier = 0;

                // Read multiplier after ')'
                while (i < formula.length() && Character.isDigit(
                        formula.charAt(i))) {
                    multiplier = multiplier * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (multiplier == 0)
                    multiplier = 1;

                currentSum = currentSum * multiplier;

                // Add to previous sum
                currentSum += stack.pop();
            } else if (weights.containsKey(ch)) {
                int value = weights.get(ch);
                i++;

                int count = 0;

                // Read number after element
                while (i < formula.length() && Character.isDigit(
                        formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (count == 0)
                    count = 1;

                currentSum += value * count;
            } else {
                // Skip unexpected characters
                i++;
            }
        }

        return currentSum;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "CH2",
                "(CH2)2O2",
                "((CH)2)O"
        };

        for (String formula : testCases) {
            System.out.println(formula + " => " + calculate(formula));
        }
    }
}
