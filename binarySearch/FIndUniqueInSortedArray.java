package binarySearch;

import java.util.Scanner;

public class FIndUniqueInSortedArray {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = findUnique(arr);
        System.out.println("Minimum element is: " + (min));

        sc.close();
    
    }
    
    public static int findUnique(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low+high)/2;

            if(mid+1 < arr.length && arr[mid] == arr[mid+1]){
                if(mid%2==0 && ((mid+1) %2 !=0)){
                    low = mid + 1;
                }else high = mid-1;
            }else if(mid-1>=0 && arr[mid-1]==arr[mid]){
                if((mid-1)%2==0 &&mid%2!=0){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }else{
                return arr[mid];
            }

        }
        return -1;
    }
}
