package sorting;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before sort");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,n-1);

        System.out.println("After sort");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    public static void quickSort(int arr[], int low, int high){
        if(low<high){
            int pIndex = getPiotIndex(arr,low,high);
            quickSort(arr,low,pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
    }

    public static int getPiotIndex(int arr[],int low,int high){

        int pelement = arr[low];
        int i = low;
        int j = high;
        int tmp =0 ;

        while (i<j) {
            while (arr[i] <= pelement && i<=high-1) {
                i++;
            }
            while (arr[j]>pelement && j >= low-1) {
                j--;
            }

            if(i<j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        tmp = arr[low];
        arr[low] = arr[j];
        arr[j] = tmp;

        return j;
    }
}
