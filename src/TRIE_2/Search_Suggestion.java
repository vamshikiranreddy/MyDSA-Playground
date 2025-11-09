package TRIE_2;

import java.util.*;

public class Search_Suggestion {
	static class TrieNode {
		TrieNode[] children;
		LinkedList<String> suggestions;
		boolean endOfWord;

		TrieNode() {
			children = new TrieNode[26];
			for (int i = 0; i < 26; i++)
				children[i] = null;
			suggestions = new LinkedList<>();
			endOfWord = false;
		}
	}

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		for (String word : products)
			Insert(word);
		return Search(searchWord);
	}

	static TrieNode root = new TrieNode();

	private static void Insert(String word) {
		TrieNode tempNode = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (tempNode.children[idx] == null) {
				tempNode.children[idx] = new TrieNode();
			}
			tempNode = tempNode.children[idx];

			tempNode.suggestions.add(word);
			if (tempNode.suggestions.size() > 3)
				tempNode.suggestions.pollLast();
		}
		tempNode.endOfWord = true;

	}

	private static List<List<String>> Search(String searchWord) {
		TrieNode tempNode = root;
		List<List<String>> result = new ArrayList<>();
		for(char ch : searchWord.toCharArray()) {
			int idx = ch - 'a';
			tempNode = tempNode.children[idx];
			if(tempNode == null) {
				result.add(new ArrayList<>());
			}else {
				result.add(tempNode.suggestions);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";

		List<List<String>> result = suggestedProducts(products, searchWord);

		System.out.println("Products: " + Arrays.toString(products));
		System.out.println("Search Word: " + searchWord);
		System.out.println("Suggestions:");
		for (int i = 0; i < result.size(); i++) {
			System.out.println(searchWord.substring(0, i + 1) + " -> " + result.get(i));
		}
	}
}
