import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Selection sort");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("before sort:");
        System.out.println(Arrays.toString(arr));
        
        selectionSort(arr,0,n);
        
        System.out.println("After sort:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    public static void selectionSort(int[] arr,int s, int n){
        
        int min=0;
        int index=0;

        for (int i = 0; i < n; i++) {
            min = arr[i];
            index = i;
            for (int j = i; j < n; j++) {
                if(arr[j]< min){
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr,i,index);
        }


    }
    public static void swap(int []arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
