package binarySearch;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        // BinarySearch bs = new BinarySearch();
        int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9 };
        int target = 5;
        int result = binarySearch(arr, target);
        System.out.println("Found on index->" + result);

    }

    public static int binarySearch(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }
}
