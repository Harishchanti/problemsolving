package backtracking;

import java.io.*;
import java.util.*;

/*

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.




Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]


 */

public class WordSearch2 {
    static class TrieNode {
        TrieNode[] next;
        String word;

        TrieNode() {
            next = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };

        String[] words = { "oath", "pea", "eat", "rain" };
        Set<String> resultSet = new HashSet<String>();
        TrieNode root = build(words);
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DFS(board, root, i, j, resultSet);
            }
        }
        resultSet.forEach(System.out::println);
    }

    static TrieNode build(String[] word) {

        TrieNode root = new TrieNode();

        for (String w : word) {
            TrieNode s = root;
            for (char c : w.toCharArray()) {
                if (s.next[c - 'a'] == null) {
                    s.next[c - 'a'] = new TrieNode();
                }
                s = s.next[c - 'a'];
            }
            s.word = w;
        }

        return root;
    }

    static void DFS(char[][] board, TrieNode root, int i, int j,
            Set<String> result) {

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0
                || board[i][j] == '$' || root.next[board[i][j] - 'a'] == null) {
            return;
        }

        if (root.next[board[i][j] - 'a'].word != null) {
            result.add(root.next[board[i][j] - 'a'].word);
        }

        root = root.next[board[i][j] - 'a'];
        char c = board[i][j];
        board[i][j] = '$';

        DFS(board, root, i - 1, j, result);
        DFS(board, root, i + 1, j, result);
        DFS(board, root, i, j + 1, result);
        DFS(board, root, i, j - 1, result);

        board[i][j] = c;
    }
}
