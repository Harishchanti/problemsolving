package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoSuggestion {
    static TrieNode root = new TrieNode("");

    public static void main(String[] args) {
        String str = "Hello World hero heppi food workout ";
        String[] wordsArray = str.split(" ");
        for (String s : wordsArray) {
            insertInTrie(s);
        }
        System.out.println(search("hello"));
        System.out.println(search("heroo"));

        List<String> suggestions = getSuggestions("he");
        suggestions.forEach(System.out::println);
    }

    private static List<String> getSuggestions(String str) {
        List<String> suggestionList = new ArrayList<String>();
        char[] chars = str.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.hm.containsKey(chars[i])) break;
            temp = temp.hm.get(chars[i]);
        }

        for (Map.Entry<Character, TrieNode> es : temp.hm.entrySet()) {
            getWords(es.getValue(), suggestionList);
        }
        return suggestionList;
    }

    private static void getWords(TrieNode tr, List<String> stringList) {

        if (tr.isWord) {
            stringList.add(tr.subString);
            return;
        }
        for (Map.Entry<Character, TrieNode> es : tr.hm.entrySet()) {
            getWords(es.getValue(), stringList);
        }
    }

    private static boolean search(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.hm.containsKey(chars[i])) return false;
            temp = temp.hm.get(chars[i]);
        }
        return temp != null && temp.isWord;
    }

    private static void insertInTrie(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.hm.containsKey(chars[i])) {
                temp.hm.put(chars[i], new TrieNode(s.substring(0, i + 1)));
            }
            temp = temp.hm.get(chars[i]);
        }
        temp.isWord = true;
    }

}


class TrieNode {
    Map<Character, TrieNode> hm;
    boolean isWord;
    String subString;

    public TrieNode(String subString) {
        this.hm = new HashMap<>();
        this.isWord = false;
        this.subString = subString;
    }

}