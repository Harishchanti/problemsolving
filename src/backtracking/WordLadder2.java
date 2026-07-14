package backtracking;

import java.util.*;
/*
Time complexity : 𝑶(𝑴𝟐×𝑵+𝑲×𝑴)

 */

public class WordLadder2 {
    public static void main(String[] args) {
        /*
 startLeximon = "hit"
// endLeximon = "cog"
// lexidex = ["hot","dot","dog","lot","log","cog"]

// Output:
// [
//   ["hit","hot","dot","dog","cog"],
//   ["hit","hot","lot","log","cog"]
// ]I*/

        String start = "hit";
        String end = "cog";
        List<String> wordList =
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result =
                getAllPossibleTransformations(start, end,
                        wordList);

        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    static List<List<String>> getAllPossibleTransformations(String beginWord,
            String endWord, List<String> wordList) {

        /**
         * Find all shortest transformation sequences from beginWord to endWord.
         * Uses BFS to build distance map, then DFS to enumerate all shortest paths.
         */
        // Convert wordList to Set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord not in wordList, no transformation possible
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }

        // BFS Phase: Build distance map showing shortest distance from beginWord
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, Integer> distances = new HashMap<>();
        distances.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentDistance = distances.get(currentWord);

            // Try all one-letter transformations
            for (int i = 0; i < currentWord.length(); i++) {

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == currentWord.charAt(i)) {
                        continue;
                    }

                    // Generate neighbor word
                    String neighbor = currentWord.substring(0,
                            i) + c + currentWord.substring(i + 1);


                    // If neighbor is in wordSet and not visited
                    if (wordSet.contains(neighbor) && !distances.containsKey(
                            neighbor)) {
                        distances.put(neighbor, currentDistance + 1);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // If endWord not reached, return empty list
        if (!distances.containsKey(endWord)) {
            return new ArrayList<>();
        }

        // DFS Phase: Backtrack from endWord to beginWord using distance map
        List<List<String>> allPaths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        currentPath.add(endWord);

        backtrack(endWord, beginWord, distances, currentPath, allPaths);
        return allPaths;
    }

    private static void backtrack(String word, String beginWord,
            Map<String, Integer> distances,
            List<String> path, List<List<String>> allPaths) {
        // Base case: reached beginWord
        if (word.equals(beginWord)) {
            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            allPaths.add(result);
            return;
        }

        // Try all one-letter transformations
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }

                // Generate neighbor word
                String neighbor =
                        word.substring(0, i) + c + word.substring(i + 1);

                // Only follow edges to words with distance exactly 1 less
                if (distances.containsKey(neighbor) && distances.get(
                        neighbor) == distances.get(word) - 1) {
                    path.add(neighbor);
                    backtrack(neighbor, beginWord, distances, path, allPaths);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
