package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};

        int len = findMaxLength(begin,end,arr);
        System.out.println("len: "+len);
    }

    private static int findMaxLength(String begin, String end, String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        
        q.add(new Pair<>(begin, 1));

        while (!q.isEmpty()) {
            Pair<String,Integer> p = q.poll();
            if(p.first.equals(end)) return p.second;
            bfs(p,set,q);
        }
        
       return -1;
    }

    private static void bfs(Pair<String,Integer> p, Set<String> set, Queue<Pair<String,Integer>> q) {
        String ele = p.first;
       for (int i = 0; i < ele.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char currChar = (char)('a'+j);
                String newStr = ele.substring(0, i) +currChar +ele.substring(i+1);
                if (set.contains(newStr)) {
                    q.add(new Pair<>(newStr, p.second+1));
                    set.remove(newStr);
                }
            }
       }
    }
}

