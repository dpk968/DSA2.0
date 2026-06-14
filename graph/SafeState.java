package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SafeState {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        getSafeState(arr,12);


        sc.close();
    }

    private static void getSafeState(int[][] arr, int v) {
       
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // reverse edges

        for (int i = 0; i < arr.length; i++) {
            adj.get(arr[i][1]).add(arr[i][0]);
        }

        int[] indegree =  new int[v];

        for (int i = 0; i < v; i++) {
            for(int e: adj.get(i)){
                indegree[e]++;
            }
        }

        Stack<Integer> st =  new Stack<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                st.push(i);
            }
        }

        
        while (!st.isEmpty()) {
            int e = st.pop();
            System.out.println(e);

            for(int ver:adj.get(e)){
                indegree[ver]--;
                if(indegree[ver]==0){
                    st.push(ver);
                }
            }

        }

    }


}
