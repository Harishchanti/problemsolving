package string;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String stream = "aabc";

        printFirstNonRepeating(stream);
    }

    public static void printFirstNonRepeating(String stream) {
        int[] freq = new int[26]; // for lowercase letters
        Queue<Character> queue = new LinkedList<>();

        for (char ch : stream.toCharArray()) {

            // Step 1: update freq and queue
            freq[ch - 'a']++;
            queue.offer(ch);

            // Step 2: remove repeating chars from front
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // Step 3: print result
            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }
    }
}
