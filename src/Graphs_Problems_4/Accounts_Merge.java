package Graphs_Problems_4;

import java.util.*;

public class Accounts_Merge {

    static class Solution {
        class DisjointSet {
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
            void Union(int u,int v){
                int Up_u = findUp(u);
                int Up_v = findUp(v);
                if(Up_u == Up_v) return;
                if(rank[Up_v] < rank[Up_u]){
                    parent[Up_v] = Up_u;
                }else if(rank[Up_u] < rank[Up_v]){
                    parent[Up_u] = Up_v;
                }else{
                    parent[Up_v] = Up_u;
                    rank[Up_u]++;
                }
            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n = accounts.size();
            DisjointSet ds = new DisjointSet(n);

            // Map email -> account index
            Map<String,Integer> MailToIdx = new HashMap<>();
            for(int i = 0;i<n;i++){
                for(int j = 1;j<accounts.get(i).size();j++){
                    String mail = accounts.get(i).get(j);
                    if(!MailToIdx.containsKey(mail)){
                        MailToIdx.put(mail,i);
                    }else{
                        ds.Union(i,MailToIdx.get(mail));
                    }
                }
            }

            // Collect merged mails for each parent
            List<String> [] mergedMail = new ArrayList[n];
            for(int i = 0;i<n;i++) mergedMail[i] = new ArrayList<>();

            for(Map.Entry<String,Integer> entry : MailToIdx.entrySet()){
                String Mail = entry.getKey();
                int node = ds.findUp(entry.getValue());
                mergedMail[node].add(Mail);
            }

            // Build result
            List<List<String>> result = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if(mergedMail[i].isEmpty()) continue;
                Collections.sort(mergedMail[i]);
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0)); // ✅ use parent’s name
                temp.addAll(mergedMail[i]);
                result.add(temp);
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));

        List<List<String>> merged = sol.accountsMerge(accounts);

        System.out.println("Merged Accounts:");
        for(List<String> acc : merged){
            System.out.println(acc);
        }
    }
}
