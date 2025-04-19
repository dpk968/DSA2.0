package recursion;


import java.util.Arrays;
import java.util.Scanner;

public class PrintAllWithOut {
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
            printPatternWithOut(arr,0);
        }
        sc.close();
    }

    public static void printPatternWithOut(int[] arr, int idx){
        if(idx==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr,i,idx);
            printPatternWithOut(arr, idx+1);
            swap(arr, idx, i);
        }
    }

    public static void swap(int[] arr,int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
