package TRIE;

import java.util.*;

public class Implementation_TRIE {
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

	public static void Insert(String word) {
		TrieNode tempNode = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a'; // a - z if A-Z,a-zor !@#..... use 256
			if (tempNode.children[idx] == null) {
				tempNode.children[idx] = new TrieNode();
			}
			tempNode = tempNode.children[idx];
		}
		tempNode.endOfWord = true;
	}
	
	public static boolean Search(String word) {
		TrieNode tempNode = root;
		for(char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if(tempNode.children[idx] == null) return false;
			tempNode = tempNode.children[idx];
		}
		return tempNode.endOfWord;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The NumOfWords :- ");
		int size = in.nextInt();
		in.nextLine();
		System.out.println("Enter The Elements");
		for(int i = 0;i<size;i++) {
			String word = in.nextLine();
			Insert(word);
		}
		System.out.println("Enter The Num Of Quires");
		int numOfQuires = in.nextInt();
		in.nextLine();
		System.out.println("Enter The Words for Quires : -");
		for(int i = 0;i<numOfQuires;i++) {
			String q = in.nextLine();
			if(Search(q)) System.out.println("Yes The Word is Present In The Trie");
			else System.out.println("No The Word is Not Present In The Trie");
		}
		in.close();
	}

}
