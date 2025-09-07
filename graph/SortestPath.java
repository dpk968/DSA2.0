package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortestPath {
    public static void main(String[] args) {
        List<List<Pair<Integer,Integer>>> adj =  new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Pair<>(1,2));
        adj.get(1).add(new Pair<>(3,1));
        adj.get(2).add(new Pair<>(3,3));

        adj.get(4).add(new Pair<>(0,3));
        adj.get(4).add(new Pair<>(2,1));

        adj.get(5).add(new Pair<>(4,1));

        adj.get(6).add(new Pair<>(4,2));
        adj.get(6).add(new Pair<>(5,3));

        int[] sortesPath = getSortedPathFromSrc(adj,7,6);
        System.out.println(Arrays.toString(sortesPath));

    }

    private static int[] getSortedPathFromSrc(List<List<Pair<Integer,Integer>>> adj, int V, int src) {
        int[] path = new int[V];
        Arrays.fill(path, Integer.MAX_VALUE);
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(src, 0));
        path[src] = 0;

        while (!q.isEmpty()) {
            Pair<Integer,Integer> p = q.poll();
            for (int index = 0; index < adj.get(p.first).size(); index++) {
                if (adj.get(p.first).get(index).second+p.second<path[adj.get(p.first).get(index).first]) {
                    path[adj.get(p.first).get(index).first] = adj.get(p.first).get(index).second+p.second;
                    q.add(new Pair<>(adj.get(p.first).get(index).first, adj.get(p.first).get(index).second+p.second));
                }
            }
        }


       return path;
    }
}

