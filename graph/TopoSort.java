package graph;

import java.util.*;

public class TopoSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adj = new ArrayList<>();
        int V = sc.nextInt();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(5).add(0);
        adj.get(5).add(2);

        printTopoSort(adj,V);

        sc.close();

    }

    public static List<Integer> printTopoSort(List<List<Integer>> adj, int V) {

        List<Integer> topo = new ArrayList<>();

        int[] indeg = new int[V];

        for (int i = 0; i < V; i++) {
            for(int e:adj.get(i)){
                indeg[e]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(indeg[i]==0){
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int e = q.poll();
            topo.add(e);
            System.out.print(e+" ");
            for(int ele:adj.get(e)){
                indeg[ele]--;
                if(indeg[ele]==0){
                    q.add(ele);
                }
            }

        }

        return topo;
    }

    public static List<Integer> printTopoSort(List<List<Integer>> adj, int V, int[] indeg) {

        List<Integer> topo = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(indeg[i]==0){
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int e = q.poll();
            topo.add(e);
            System.out.print(e+" ");
            for(int ele:adj.get(e)){
                indeg[ele]--;
                if(indeg[ele]==0){
                    q.add(ele);
                }
            }

        }

        return topo;
    }
}
