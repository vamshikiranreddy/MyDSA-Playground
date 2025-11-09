package TRIE_2;

import java.util.*;

public class Phone_Dictionary {
	static class TrieNode {
		TrieNode[] children;
		Set<String> suggestions; // for limiting unique
		boolean endOfWord;

		TrieNode() {
			children = new TrieNode[256];
			for (int i = 0; i < 256; i++)
				children[i] = null;
			suggestions = new TreeSet<>();
			endOfWord = false;
		}
	}

	static TrieNode root = new TrieNode();
	
	private static void insert(String name) {
		TrieNode tempNode = root;
		for(char ch : name.toCharArray()) {
			int idx = ch - 'a';
			if(tempNode.children[idx] == null) {
				tempNode.children[idx] = new TrieNode();
			}
			tempNode = tempNode.children[idx];
			tempNode.suggestions.add(name);
		}
		tempNode.endOfWord = true;
	}
	
	private static List<List<String>> search(String searchWord) {
		TrieNode tempNode = root;
		List<List<String>> result = new ArrayList<>();
		for(char ch : searchWord.toCharArray()) {
			int idx = ch - 'a';
			if(tempNode != null) {
				tempNode = tempNode.children[idx];
			}
			if(tempNode == null) {
				result.add(new ArrayList<>());
			}else {
				result.add(new ArrayList<>(tempNode.suggestions));
			}
		}
		return result;
	}

	private static List<List<String>> PhoneDictionary(String[] names, String searchWord) {
		for(String name : names) insert(name);
		return search(searchWord);
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] names = {
			    // a
			    "alice", "aaron", "amelia",
			    // b
			    "brian", "bella", "benjamin",
			    // c
			    "chris", "catherine", "charles",
			    // d
			    "david", "diana", "daniel",
			    // e
			    "ethan", "ella", "edward",
			    // f
			    "frank", "fiona", "faith",
			    // g
			    "george", "grace", "gavin",
			    // h
			    "henry", "hannah", "helen",
			    // i
			    "isaac", "ivy", "irene",
			    // j
			    "jack", "julia", "james",
			    // k
			    "kevin", "katherine", "kyle",
			    // l
			    "liam", "lily", "lucas",
			    // m
			    "michael", "mia", "matthew",
			    // n
			    "noah", "nora", "nathan",
			    // o
			    "oliver", "olivia", "oscar",
			    // p
			    "paul", "pamela", "peter",
			    // q
			    "quinn", "queenie", "quentin",
			    // r
			    "ryan", "rachel", "robert",
			    // s
			    "sophia", "samuel", "steven",
			    // t
			    "thomas", "tracy", "taylor",
			    // u
			    "uma", "ulysses", "ulrich",
			    // v
			    "victor", "violet", "vanessa","vamshi",
			    // w
			    "william", "wendy", "walter",
			    // x
			    "xander", "xenia", "xavier",
			    // y
			    "yara", "yvonne", "yusuf",
			    // z
			    "zachary", "zoe", "zara"
			};

		System.out.println("Enter The Search Word");
		String searchWord = in.nextLine();
		List<List<String>> result = PhoneDictionary(names, searchWord);
		for (int i = 0; i < searchWord.length(); i++) {
			String s = searchWord.substring(0, i + 1);
			System.out.println(s + "->" + result.get(i));
		}
		in.close();
	}
}
