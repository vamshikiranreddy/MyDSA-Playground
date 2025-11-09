package Graphs_Problems_3;

import java.util.*;

public class Word_Ladder {

    static class Pair {
        String word;
        int level;
        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0; // early exit

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currWord = current.word;
            int currLevel = current.level;

            if (currWord.equals(endWord)) return currLevel;

            for (int i = 0; i < currWord.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedArray = currWord.toCharArray();
                    replacedArray[i] = c;
                    String replacedString = new String(replacedArray);
                    if (set.contains(replacedString)) {
                        set.remove(replacedString);
                        queue.offer(new Pair(replacedString, currLevel + 1));
                    }
                }
            }
        }
        return 0;
    }

    // Test example
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + result);
    }
}
