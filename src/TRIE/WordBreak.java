package TRIE;

import java.util.*;

public class WordBreak {

    // Trie Node
    static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    // Root of the Trie
    private TrieNode root = new TrieNode();

    // Insert word into Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.endOfWord = true;
    }

    // Word Break using DFS + Memoization + Trie
    public boolean wordBreak(String s, List<String> wordDict) {
        // Insert all dictionary words into Trie
        for (String word : wordDict) {
            insert(word);
        }
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, memo);
    }

    // DFS search using Trie
    private boolean dfs(String s, int start, Boolean[] memo) {
        if (start == s.length()) return true; // reached end
        if (memo[start] != null) return memo[start];

        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) break; // no match
            node = node.children[idx];
            if (node.endOfWord && dfs(s, i + 1, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }

    // Main method for testing
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Can \"" + s1 + "\" be segmented? " + wb.wordBreak(s1, dict1)); // true

        WordBreak wb2 = new WordBreak();
        String s2 = "catsandog";
        List<String> dict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Can \"" + s2 + "\" be segmented? " + wb2.wordBreak(s2, dict2)); // false

        WordBreak wb3 = new WordBreak();
        String s3 = "applepenapple";
        List<String> dict3 = Arrays.asList("apple", "pen");
        System.out.println("Can \"" + s3 + "\" be segmented? " + wb3.wordBreak(s3, dict3)); // true
    }
}
