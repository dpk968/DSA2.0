package recursion;

import java.util.ArrayList;
import java.util.List;

public class GraphColoring {
    public static void main(String[] args) {
        int N = 4, M = 3;
        List <Integer> [] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList <> ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);


        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public static boolean graphColoring(List < Integer > [] G ,int[] color,int idx, int M){
        if(idx==color.length) return true;
        for (int i = 1; i <=M; i++) {
            if (isSafe(G,color,idx,i)) {
                color[idx] = i;
                if(graphColoring(G, color, idx+1, M)){
                    return true;
                }
                color[idx] = 0;
            }
        }
        return false;
    }

public static boolean isSafe(List<Integer> [] G, int[] color,int n,int M){
    for (int i : G[n]) {
        if(color[i]==M) return false;
    }
    return true;
}


}
