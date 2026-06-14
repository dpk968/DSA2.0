package graph;

import java.util.List;

public class Graph {
    public static void printAdjList(List<List<Integer>> adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}
