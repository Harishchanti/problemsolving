package stack;

import java.util.*;

/*
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.

Example 1:

Input: temperatures = [30,38,30,36,35,40,28]

Output: [1,4,1,2,1,0,0]
Example 2:

Input: temperatures = [22,21,20]

Output: [0,0,0]
 */
public class DailyTemprature {
    public static void main(String[] args) {
        int[] a = { 39, 38, 37, 36, 35, 40, 37 };
        int[] result = dailyTemperatures(a);
        for (int t : result)
            System.out.print(t+" ");
    }

    static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<Integer>();
        int n = temperatures.length, j = n - 1;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[j--] = 0;
            } else {
                result[j--] = st.peek() - i;
            }

            st.push(i);
        }

        return result;
    }
}
