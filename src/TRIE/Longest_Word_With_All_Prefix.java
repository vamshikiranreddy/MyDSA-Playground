package TRIE;

import java.util.*;

public class Longest_Word_With_All_Prefix {
	static class TrieNode {
		TrieNode[] children;
		boolean endOfWord;

		TrieNode() {
			children = new TrieNode[26];
			for (int i = 0; i < 26; i++)
				children[i] = null;
			endOfWord = false;
		}
	}

	static TrieNode root = new TrieNode();

	public static void insert(String word) {
		TrieNode temp = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (temp.children[idx] == null) {
				temp.children[idx] = new TrieNode();
			}
			temp = temp.children[idx];
		}
		temp.endOfWord = true;
	}

	public static void main(String[] args) {
		String[] words = { "a", "ap", "app", "appl", "apple", "apply", "bannana" };
		System.out.println("The Longest Word With All Their Prefixes In The Arrray is :- " + LongestWord(words));
	}

	private static boolean isLongestWordPrefix(String word) {
		TrieNode temp = root;
		for(char ch : word.toCharArray()) {
			int idx = ch - 'a';
			temp = temp.children[idx];
			if(temp == null || !temp.endOfWord) return false;
		}
		return true;
	}

	private static String LongestWord(String[] words) {
		for (String word : words)
			insert(word);
		String result = "";
		for (String word : words) {
			if (isLongestWordPrefix(word)) {
				if (word.length() > result.length()
						|| ((word.length() == result.length()) && word.compareTo(result) < 0)) {
					result = word;
				}
			}
		}
		return result;
	}
}
