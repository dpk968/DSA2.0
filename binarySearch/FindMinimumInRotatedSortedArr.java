package binarySearch;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = findMin(arr);
        System.out.println("Minimum element is: " + (min));

        sc.close();
    }
    
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int idx = -1;
        while (low<=high) {
            int mid = (low + high) / 2;

            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min = arr[low];
                    idx = low;
                }
                low = mid + 1;
            }else{
                if(arr[mid]<min){
                    min = arr[mid];
                    idx = mid;
                }
                high = mid - 1;
            }
        }

        return idx;
    }
}
