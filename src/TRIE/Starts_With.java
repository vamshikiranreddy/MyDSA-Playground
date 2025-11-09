package TRIE;

public class Starts_With {

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

    // Insert a word into the Trie
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

    // Search for a full word
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.endOfWord;
    }

    // Check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        Starts_With trie = new Starts_With();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");

        System.out.println("Search 'apple' : " + trie.search("apple"));   // true
        System.out.println("Search 'app'   : " + trie.search("app"));     // true
        System.out.println("Search 'appl'  : " + trie.search("appl"));    // false
        System.out.println("StartsWith 'ap': " + trie.startsWith("ap"));  // true
        System.out.println("StartsWith 'ba': " + trie.startsWith("ba"));  // true
        System.out.println("StartsWith 'cat': " + trie.startsWith("cat"));// false
    }
}
