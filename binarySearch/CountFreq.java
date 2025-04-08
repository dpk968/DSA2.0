package binarySearch;

import java.util.Scanner;

public class CountFreq {
    public static int countFreq(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int firstOccurence = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                firstOccurence = mid;
                right = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(firstOccurence == -1){
            return 0;
        }
        left = 0;
        right = arr.length-1;
        int lastOccurence = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                lastOccurence = mid;
                left = mid+1;
            }else if(arr[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return lastOccurence-firstOccurence+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int count = countFreq(arr, target);
        System.out.println(count);
        sc.close();
    }
   
}
