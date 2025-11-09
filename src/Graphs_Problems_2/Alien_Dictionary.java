package Graphs_Problems_2;

import java.util.*;

public class Alien_Dictionary {
	private static String alienOrder(String[] words) {
		List<List<Integer>> alist = new ArrayList<>();
		for (int i = 0; i < 26; i++)
			alist.add(new ArrayList<>());
		boolean[] present = new boolean[26];
		for (String word : words) {
			for (char c : word.toCharArray()) {
				present[c - 'a'] = true;
			}
		}
		int n = words.length;
		for (int i = 0; i < n - 1; i++) {
			String s1 = words[i];
			String s2 = words[i+1];
			int len = Math.min(s1.length(), s2.length());
			boolean diff = false;
			for (int j = 0; j < len; j++) {
				int u = s1.charAt(j) - 'a';
				int v = s2.charAt(j) - 'a';
				if (u != v) {
					alist.get(u).add(v);
					diff = true;
					break;
				}
			}
			if (!diff && s1.length() > s2.length())
				return "";
		}
		List<Integer> topo = TopoSort(alist);
		//Cycle Detection
		int count = 0;
		for(boolean p : present) if(p) count++;
		if(topo.size() < count) return""; // CycleDetected
		
		StringBuilder result = new StringBuilder();
		for(int Node : topo) {
			if(present[Node]) {
				result.append((char)(Node +'a')); // converting into char of the asciii 
			}
		}
		return result.toString();
	}

	private static List<Integer> TopoSort(List<List<Integer>> alist) {
		int N = alist.size();
		int[] indegree = new int[N];
		for (int i = 0; i < N; i++) {
			if (alist.get(i) != null) {
				for (int node : alist.get(i)) {
					indegree[node]++;
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int topNode = q.poll();
			list.add(topNode);
			for (int Nnode : alist.get(topNode)) {
				indegree[Nnode]--;
				if (indegree[Nnode] == 0) {
					q.offer(Nnode);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		String order = alienOrder(words);
		System.out.println(order); // Example output: "wertf"
	}

}
