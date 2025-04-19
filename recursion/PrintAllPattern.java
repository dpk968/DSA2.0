package recursion;

import java.util.*;
import java.util.Scanner;
public class PrintAllPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Print the pattern using recursion
        for(int i=0;i<n;i++){
            int l = sc.nextInt();
            int[] arr = new int[l];
            for(int j=0;j<l;j++){
                arr[j] = sc.nextInt();
            }
            boolean vis[] = new boolean[l];
            List<Integer> ds = new ArrayList<>();
            printPattern(arr,0, ds, vis);
        }
        sc.close();
        
    }

    public static void printPattern(int[] arr, int idx, List<Integer> ds,boolean vis[]){
        if (arr.length==0) {
            return;
        }
        if (idx==arr.length) {
            System.out.println(ds);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!vis[i]){
                ds.add(arr[i]);
                vis[i] = true;
                printPattern(arr, idx+1, ds, vis);  
                vis[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
    
}
