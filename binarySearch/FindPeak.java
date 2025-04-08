package binarySearch;

import java.util.Scanner;

public class FindPeak {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = findPeak(arr);
        System.out.println("Minimum element is: " + (min));

        sc.close();

    }

    public static int findPeak(int[] arr) {

        if (arr[0] > arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }else if(arr[mid-1] < arr[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;

    }
}
