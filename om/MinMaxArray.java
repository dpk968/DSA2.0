package om;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxArray {
    
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        findFirstMinAndMax(arr);

        sc.close();
    }

    private static void findFirstMinAndMax(int[] arr) {
       int[] arr1 = new int[arr.length];
       int[] arr2 = new int[arr.length];



       for (int i = 0; i < arr.length; i++) {
        arr1[i] = -1;
        for (int j = i+1; j < arr.length; j++) {
            if(arr[i]<arr[j]){
                arr1[i]=arr[j];
                break;
            }
        }
       }

       System.out.println(Arrays.toString(arr1));

        int e=0;
       for (int i = 0; i < arr1.length; i++) {
        int idx = findIdx(arr1[i],arr);
        if(idx==-1){
            arr2[e] = 0;
            e++;
            continue;
        }
        for (int j = idx-1; j >= 0; j--) {
            if(arr[j]<arr1[i]){
                arr2[e] = arr[j];
                e++;
                break;
            }
        }
    }
    System.out.println(Arrays.toString(arr2));

    }

    private static int findIdx(int i, int[] arr) {
    
        for (int j = arr.length-1; j >=0; j--) {
            if(arr[j]==i) {
                return j;
            }
        }
        return -1;
    }
}
