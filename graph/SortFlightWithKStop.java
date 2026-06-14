package graph;

import java.util.*;
public class SortFlightWithKStop {


    public static void main(String[] args) {
//         Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1

// Output: 200


        int n=3;
        int[][] flight = {
            {0,1,100},{1,2,100},{0,2,500}
        };

        System.out.println(CheapestFlight(n, flight, 0, 2, 1));



        // Input: n = 3, flights = [[0, 1, 100], [1, 2, 100], [0, 2, 500]], src = 0, dst = 2, k = 0 
        // Output: 500
        int n2=3;
        int[][] flight2 = {
            {0,1,100},{1,2,100},{0,2,500}
        };
        System.out.println(CheapestFlight(n2, flight2, 0, 2, 0));

    }

    public static int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {

        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new ArrayList<>(List.of(flights[i][1], flights[i][2])));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer,Integer>(0, src));

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0;i<size;i++){
                Pair<Integer,Integer> p = q.poll();
                int wt = p.first;
                int node = p.second;
                for(List<Integer> e:adj.get(node)){
                    if(wt+e.get(1)<dist[e.get(0)]){
                        dist[e.get(0)] = wt+e.get(1);
                        q.add(new Pair<Integer,Integer>(wt+e.get(1), e.get(0)));
                    }
                }

            }
            if(K==0){
                if(dist[dst]!=Integer.MAX_VALUE){
                    return dist[dst];
                }else
                    return -1;
            }else
                K--;
        }

        return -1;
    }

}
