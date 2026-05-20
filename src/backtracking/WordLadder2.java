package backtracking;

import java.util.*;

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
        Set<String> set = new HashSet<String>(wordList);

        List<List<String>> result =
                getAllPossibleTransformations(start, end,
                        set);

        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    static List<List<String>> getAllPossibleTransformations(String start,
            String end, Set<String> set) {

        Map<String, List<String>> adjMap = new HashMap<>();

        List<List<String>> result = new ArrayList<>();

        Queue<String> q = new LinkedList<String>();
        q.add(start);

        while (!q.isEmpty()) {
            int l = q.size();
            String ele = q.poll();

            for (int j = 0; j < l; j++) {

                adjMap.computeIfAbsent(ele, k -> new ArrayList<>());

                char[] temp = ele.toCharArray();

                for (int i = 0; i < temp.length; i++) {

                    char cr = temp[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        temp[i] = c;
                        String itermStr = String.valueOf(temp);

                        if (!set.contains(itermStr) || end.equalsIgnoreCase(
                                itermStr) || ele.equalsIgnoreCase(
                                itermStr) || adjMap.containsKey(itermStr)) {
                            continue;
                        }

                        adjMap.get(ele).add(itermStr);
                        q.add(itermStr);

                    }
                    temp[i] = cr;
                }
            }
        }
        return result;
    }
}
