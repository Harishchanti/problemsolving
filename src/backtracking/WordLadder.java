package backtracking;

import java.util.*;

/*
https://www.geeksforgeeks.org/dsa/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
 */
public class WordLadder {

    private static int DFS(String beginWord, String endWord, List<String> wordList,Map<String,Integer> map) {



        if(beginWord.equals(endWord)) {
            return 1;
        }

        map.put(beginWord,1);
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < beginWord.length(); i++) {

            char[] beginArr = beginWord.toCharArray();

            char originalChar = beginArr[i];

            for(char j = 'a' ; j <'z' ; j++) {

                beginArr[i] = j;
                String transformedStr = new String(beginArr);

                if(map.containsKey(transformedStr) && map.get(transformedStr) == 0) {

                    min = Math.min(min , 1 + DFS(transformedStr,endWord,wordList,map) );

                }

            }
            beginArr[i] = originalChar;

        }

        map.put(beginWord,0);

        return min;


    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String,Integer> map = new HashMap<String,Integer>();

        for(String word : wordList) {
            map.put(word,0);
        }

        int result = DFSV2(beginWord,endWord,wordList,map);

        return result != Integer.MAX_VALUE ? result : 0;

    }

    private static int DFSV2(String beginWord, String endWord, List<String> wordList,Map<String,Integer> map) {

        if(beginWord.equals(endWord)) {
            return 1;
        }

        map.put(beginWord,1);

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < beginWord.length(); i++) {

            char[] beginArr = beginWord.toCharArray();

            char originalChar = beginArr[i];

            for(char j = 'a' ; j <='z' ; j++) {
                beginArr[i] = j;
                String transformedStr = new String(beginArr);

                if(map.containsKey(transformedStr) && map.get(transformedStr) == 0) {

                    min = Math.min(min , 1 + DFSV2(transformedStr,endWord,wordList,map) );

                }

            }
            beginArr[i] = originalChar;
        }
        map.put(beginWord,0);
        return min;
    }

    public static int minWordTransform(String start, String target,
            Map<String, Integer> mp) {
        // If start word is the same as target, no transformation is needed
        if (start.equals(target))
            return 1;

        int mini = Integer.MAX_VALUE;

        // Mark current word as visited
        mp.put(start, 1);

        // Try changing each character of the word
        for (int i = 0; i < start.length(); i++) {
            char[] chars = start.toCharArray();
            char originalChar = chars[i];

            // Try all possible lowercase letters at position i
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String transformed = new String(chars);

                // If the new word exists in dictionary and is not visited
                if (mp.containsKey(transformed) && mp.get(transformed) == 0) {
                    // Recursive call for next transformation
                    mini = Math.min(mini, 1 +
                            minWordTransform(transformed, target, mp));
                }
            }

            // Restore original character before moving to the next position
            chars[i] = originalChar;
        }

        // Mark current word as unvisited (backtracking)
        mp.put(start, 0);

        return mini;
    }

    // Wrapper function to prepare the map and call recursive function
    public static int wordLadder(String start, String target,
            ArrayList<String> arr) {

        Map<String, Integer> mp = new HashMap<>();

        // Initialize all words from the dictionary as unvisited
        for (String word : arr) {
            mp.put(word, 0);
        }

        int result = minWordTransform(start, target, mp);
        if (result == Integer.MAX_VALUE)
            result = 0;

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(
                "poon", "plee", "same", "poie", "plie", "poin", "plea"));

        String[] arr = {
                "poon", "plee", "same", "poie", "plie", "poin", "plea" };

        String start = "toon";
        String target = "plea";

       // System.out.println(wordLadder(start, target, arrList));
       System.out.println(wordLadderUsingBFS(start, target, arr));

        //  ["hot","dot","dog","lot","log","cog"]
        // ["hot","dot","dog","lot","log"]

        String start1 = "hit";
        String target1 = "cog";

        ArrayList<String> arrList1 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(wordLadder(start1, target1, arrList1));
        //System.out.println(ladderLength(start1, target1, arrList1));
    }

    static int wordLadderUsingBFS(String start, String target, String[] arr) {

        // Set to keep track of unvisited words
        Set<String> st = new HashSet<String>();
        for (int i = 0; i < arr.length; i++)
            st.add(arr[i]);

        // Store the current chain length
        int res = 0;
        int m = start.length();

        // Queue to store words to visit
        Queue<String> words = new LinkedList<>();
        words.add(start);

        while (!words.isEmpty()) {
            int len = words.size();
            res++;
            // Iterate through all words at the same level
            for (int i = 0; i < len; ++i) {
                String word = words.poll();

                // For every character of the word
                for (int j = 0; j < m; ++j) {

                    // Retain the original character
                    // at the current position
                    char[] wordArr = word.toCharArray();
                    //char ch = wordArr[j];

                    // Replace the current character with
                    // every possible lowercase alphabet
                    for (char c = 'a'; c <= 'z'; ++c) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        // Skip the word if already added
                        // or not present in set
                        if (!st.contains(newWord))
                            continue;

                        // If target word is found
                        if (newWord.equals(target))
                            return res + 1;

                        // Remove the word from set
                        st.remove(newWord);

                        // And push the newly generated word
                        // which will be a part of the chain
                        words.add(newWord);
                    }

                    // Restore the original character
                    //wordArr[j] = ch;
                }
            }

        }

        return 0;
    }
}
