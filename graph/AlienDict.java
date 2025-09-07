package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienDict {
    public static void main(String[] args) {
        String[] arr = {"baa","abcd","abca","cab","cad"};
        String dict = getAlienDict(arr,5,4);
        System.out.println(dict);
    }

    private static String getAlienDict(String[] arr, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<k;i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[k];
        
        for (int i = 0; i < n-1; i++) {
            String s1 = arr[i];
            String s2 = arr[i+1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j)!=s2.charAt(j)) {
                    int u = s1.charAt(j)-'a';
                    int v = s2.charAt(j)-'a';
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        indegree[v]++;
                    }
                    break;
                }
            }
        }
        List<Integer> getTopo = TopoSort.printTopoSort(adj, k, indegree);
        String s = "";
        for (int i = 0; i < getTopo.size(); i++) {
            s += ((char)('a'+getTopo.get(i)))+"";
        }
       return s;
    }
}
