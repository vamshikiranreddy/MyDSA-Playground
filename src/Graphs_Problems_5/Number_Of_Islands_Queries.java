package Graphs_Problems_5;

import java.util.*;

public class Number_Of_Islands_Queries {
    static class DisjointSet{
        int [] parent;
        int [] rank;
        DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++) parent[i] = i;
        }
        int findUp(int node){
            if(node == parent[node]) return node;
            return parent[node] = findUp(parent[node]);
        }
        boolean Union(int u,int v){
            int Up_u = findUp(u);
            int Up_v = findUp(v);
            if(Up_u == Up_v) return false;
            if(rank[Up_u] < rank[Up_v]){
                parent[Up_u] = Up_v;
            }else if(rank[Up_v] < rank[Up_u]){
                parent[Up_v] = Up_u;
            }else{
                parent[Up_v] = Up_u;
                rank[Up_u]++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int rows = 3, cols = 3;
        int[][] operators = {
            {0, 0},
            {0, 1},
            {1, 2},
            {2, 1},
            {1, 1}
        };

        List<Integer> result = numOfIslands(rows, cols, operators);
        System.out.println("Number of islands after each operation:");
        System.out.println(result);
    }

	public static List<Integer> numOfIslands(int m, int n, int[][] operators) {
		DisjointSet ds = new DisjointSet(m*n);
		boolean [] visited = new boolean[m*n];
		List<Integer> result  = new ArrayList<>();
		int count = 0;
		int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
		for(int [] operation : operators) {
			int r = operation[0];
			int c = operation[1];
			int idx = (r * n) + c;
			if(visited[idx]) {
				result.add(count);
				continue;
			}
			visited[idx] = true;
			count++;
			for(int [] direction : directions) {
				int nr = r + direction[0];
				int nc = c + direction[1];
				if(nr < 0 || nr >= m || nc < 0|| nc >= n) continue;
				int nidx = (nr * n) + nc;
				if(visited[nidx] && ds.Union(idx, nidx)) {
					count--;
				}
			}
			result.add(count);
		}
		return result;
	}
}
