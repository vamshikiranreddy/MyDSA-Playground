package TRIE;

import java.util.*;

public class count_Unique_SubString {
	static class TrieNode {
		TrieNode[] children;
		boolean endOfWord;

		TrieNode() {
			children = new TrieNode[26];
			endOfWord = false;
		}
	}

	static TrieNode root = new TrieNode();

	public static void Insert(String word) {
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
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The String");
		String s = in.nextLine();
		// for prefix
		// for(int i = 0; i < s.length(); i++) {
		// String prefix = s.substring(0, i + 1);
		// }
		// for suffix
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			Insert(suffix);
		}
		int count = CountTrieNodes(root);
        System.out.println("Number of distinct substrings: " + count);
        in.close();

	}

	private static int CountTrieNodes(TrieNode root) {
		return helper(root);
	}

	private static int helper(TrieNode root) {
		if (root == null)
			return 0;
		int count = 1;
		for (int i = 0; i < 26; i++) {
			if(root.children[i] != null) {
				count += helper(root.children[i]);
			}
		}
		return count;
	}

}
